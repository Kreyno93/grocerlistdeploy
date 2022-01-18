package de.neuefische.backend;

import de.neuefische.backend.model.UserMongo;
import de.neuefische.backend.repository.ShoppingRepo;
import de.neuefische.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
//@EnableMongoRepositories(basePackageClasses = ShoppingRepo.class)
@EnableMongoRepositories(basePackageClasses = UserRepository.class)
public class BackendApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Autowired
    UserRepository userRepo;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception {
        UserMongo user1 = UserMongo.builder().username("User1").password(encoder.encode("SicheresPasswort1234!")).build();
        userRepo.save(user1);
    }
}
