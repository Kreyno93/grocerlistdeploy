package de.neuefische.backend.controller;

import de.neuefische.backend.service.MongoUserDetailsService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Collection;

@RestController
@RequestMapping("/api")
public class DemoController {

    final UserDetailsService userDetailsService;

    public DemoController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping
    String getHello(Principal principal) {
        String username = principal.getName();
        Collection<? extends GrantedAuthority> authorities =
                SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        final boolean isAllowed =
                authorities.stream()
                        .anyMatch(g -> MongoUserDetailsService.AUTHORITY_API_READWRITE.equals(g.getAuthority()));
        if (isAllowed) {
            return "Hallo API " + username;
        } else {
            return "Darfst du nicht";
        }
    }
}

