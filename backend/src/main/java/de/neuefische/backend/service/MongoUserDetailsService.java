package de.neuefische.backend.service;

import de.neuefische.backend.repository.MongoUserRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MongoUserDetailsService implements UserDetailsService {


    public static final String AUTHORITY_API_READWRITE ="AUTHORITY_API_READWRITE" ;
    private final MongoUserRepository userRepository;

    public MongoUserDetailsService(MongoUserRepository repository) {
        this.userRepository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return  userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
