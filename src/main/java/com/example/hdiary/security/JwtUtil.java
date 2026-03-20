package com.example.hdiary.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

import static io.jsonwebtoken.Jwts.*;

@Component
public class JwtUtil {
    private final Key key;
    private final Long expirationMs;

    public JwtUtil(
            @Value("${jwt.secret}")
            String secret,
            @Value("${jwt.expiration}")
            Long expirationMs
    ){
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.expirationMs = expirationMs;
    }

    public String generateToken(String email) {
        return builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    private Jws<Claims> parse(String token) {
        return Jwts.parser()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
    }

    public String extractEmail(String token) {
        return parse(token)
                .getBody()
                .getSubject();
    }
}
