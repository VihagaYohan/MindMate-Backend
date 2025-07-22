package com.codenova.mindmate_backend.services;

import com.codenova.mindmate_backend.config.JwtConfig;
import com.codenova.mindmate_backend.dtos.UserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@AllArgsConstructor
@Service
public class JwtService {
    private final JwtConfig jwtConfig;

    public String generateAccessToken(UserDto userDto) {
        return generateToken(userDto, jwtConfig.getAccessTokenExpiration());
    }

    public String generateRefreshToken(UserDto userDto){
        return generateToken(userDto, jwtConfig.getRefreshTokenExpiration());
    }

    private String generateToken(UserDto userDto, int tokenExpiration) {
        return Jwts.builder()
                .subject(userDto.getId().toString())
                .claim("userId", userDto.getId().toString())
                .claim("email", userDto.getEmail())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * tokenExpiration))
                .signWith(jwtConfig.getSecretKey())
                .compact();
    }

    public boolean validateToken(String token) {
       try {
           var claims = getClaims(token);

           return claims.getExpiration().after(new Date());
       } catch (JwtException exception) {
            return false;
       }
    }

    // create token claims
    private Claims getClaims(String token) {
        var claims =  Jwts.parser()
                .verifyWith(jwtConfig.getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return claims;
    }

    // get subject from token
    public Long getUserIdFromToken(String token) {
       return Long.valueOf(getClaims(token).getSubject());
    }
}
