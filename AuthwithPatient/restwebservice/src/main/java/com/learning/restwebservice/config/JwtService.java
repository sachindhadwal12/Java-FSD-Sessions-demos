package com.learning.restwebservice.config;



import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

/**
 * Student Service's JwtService.
 *
 * Does NOT generate tokens — that's the Auth Service's job.
 * Only VALIDATES and PARSES tokens that were signed by the Auth Service
 * using the shared jwt.secret.
 */
@Component
public class JwtService {

    @Value("${jwt.secret}")
    private String secretKey;

    // ── Validate ──────────────────────────────────────────────────────────────

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // ── Extract ───────────────────────────────────────────────────────────────

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    /**
     * Extracts the role claim embedded by Auth Service at token generation time.
     * Converts it into a GrantedAuthority so Spring Security can enforce @PreAuthorize.
     */
    public UserDetails extractUserDetails(String token) {
        String username = extractUsername(token);
        String role     = extractClaim(token, claims -> claims.get("role", String.class));

        return new User(
                username,
                "",   // password not needed; we trust the token signature
                List.of(new SimpleGrantedAuthority(role))
        );
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        return claimsResolver.apply(extractAllClaims(token));
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
    }
}

