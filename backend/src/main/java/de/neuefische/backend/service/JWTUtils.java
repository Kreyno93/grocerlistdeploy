package de.neuefische.backend.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Map;

@Service
public class JWTUtils {

    final String secret = "this is a bad secret";

    public String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(Instant.now().plus(Duration.ofHours(12))))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String extractUserName(String token) {
        Claims claims = extractAllClaims(token);
        return claims.getSubject();
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        Claims claims = extractAllClaims(token);          //  Checkt ob das Ablaufdatum bis zum jetzigen Zeitpunkt
        return claims.getExpiration().before(new Date()); //  abgelaufen ist => gibt dementsprechend true or false zurück
    }

    public Boolean validateToken(String token, String username) {    // Checkt ob das token mit dem Username
        String userName = extractUserName(token);                      // nicht abgelaufen ist
        return (userName.equals(username) && !isTokenExpired(token));  // und gibts true oder false zurück
    }

}

