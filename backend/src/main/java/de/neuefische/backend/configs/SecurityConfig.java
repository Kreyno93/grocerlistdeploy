package de.neuefische.backend.configs;

import de.neuefische.backend.service.MongoUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;




    @EnableWebSecurity
    public class SecurityConfig extends WebSecurityConfigurerAdapter {

       final MongoUserDetailsService mongoUserDetailsService;

        public SecurityConfig(MongoUserDetailsService mongoUserDetailsService) {
            this.mongoUserDetailsService = mongoUserDetailsService;
        }


        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(mongoUserDetailsService);
        }


            @Override
            protected void configure(HttpSecurity http) throws Exception {
                http.csrf().disable().authorizeRequests()
                        .antMatchers("/api/**").authenticated()
                        .and().formLogin()
                        .and().httpBasic();
            }


        @Bean
        public PasswordEncoder passwordEncoder(){
            return new Argon2PasswordEncoder();
        }

    }
