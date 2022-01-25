package de.neuefische.backend.configs;

import de.neuefische.backend.filter.JwtAuthFilter;
import de.neuefische.backend.service.MongoUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
    public class SecurityConfig extends WebSecurityConfigurerAdapter {
    final JwtAuthFilter jwtAuthFilter;
       final MongoUserDetailsService mongoUserDetailsService;

        public SecurityConfig(JwtAuthFilter jwtAuthFilter, MongoUserDetailsService mongoUserDetailsService) {
            this.jwtAuthFilter = jwtAuthFilter;
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
                .antMatchers("/auth/**").permitAll()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
//                        .and().formLogin()
//                        .and().httpBasic();
    }


        @Bean
        public PasswordEncoder passwordEncoder(){
            return new Argon2PasswordEncoder();
        }
        @Bean
        public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
        }

    }
