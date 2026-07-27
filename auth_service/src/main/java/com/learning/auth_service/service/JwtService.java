package com.learning.auth_service.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    // Generate a JWT token

    @Value("${jwt.secret}")
   private String secretKey ;

   @Value("${jwt.expiration-ms}")
   private long expirationTime;

   public String generateToken(UserDetails userDetails){
       Map<String,Object> claims = new HashMap<>();
       claims.put("role",userDetails.getAuthorities()
               .iterator().next().getAuthority());
       return Jwts.builder()
               .setClaims(claims)
               .setSubject(userDetails.getUsername())
               .setIssuedAt(new java.util.Date(System.currentTimeMillis()))
               .setExpiration(new java.util.Date(System.currentTimeMillis() + expirationTime))
               .signWith(getSigningKey(), SignatureAlgorithm.HS256)
               .compact();
   }

   public Key getSigningKey() {
   return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
   }


}
