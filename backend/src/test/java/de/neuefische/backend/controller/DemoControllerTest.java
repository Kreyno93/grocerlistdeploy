package de.neuefische.backend.controller;
import de.neuefische.backend.model.LoginData;
import de.neuefische.backend.model.User;
import de.neuefische.backend.repository.MongoUserRepository;
import de.neuefische.backend.service.MongoUserDetailsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoControllerTest {

    @LocalServerPort
    private int port;

    @MockBean
    private MongoUserRepository mongoUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final WebClient webTestClient = WebClient.create();

    @Test
    void getHelloWithCredentials() {
        //GIVEN
        when(mongoUserRepository.findByUsername("test-user"))
                .thenReturn(Optional.of(User.builder()
                        .username("test-user")
                        .password(passwordEncoder.encode("12345"))
                        .accountNonExpired(true)
                        .authorities(List.of(new SimpleGrantedAuthority(MongoUserDetailsService.AUTHORITY_API_READWRITE)))
                        .credentialsNonExpired(true)
                        .accountNonLocked(true)
                        .enabled(true)
                        .build()));

        LoginData loginData = new LoginData("test-user", "12345");

        ResponseEntity<String> login = webTestClient.post()
                .uri("http://localhost:" + port + "/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(loginData)
                .retrieve()
                .toEntity(String.class)
                .block();

        String token = login.getBody();

        //WHEN
        ResponseEntity<String> getHello = webTestClient.get()
                .uri("http://localhost:"+port+"/api")
                .header("Authorization","Bearer"+token)
                .retrieve()
                .toEntity(String.class)
                .block();
        //THEN
        assertThat(getHello.getStatusCode(),is(HttpStatus.OK));
        assertThat(getHello.getBody(),is("Hallo API test-user"));
    }
}