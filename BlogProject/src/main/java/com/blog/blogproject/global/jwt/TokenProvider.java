package com.blog.blogproject.global.jwt;

import com.blog.blogproject.user.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class TokenProvider {

    private final JwtProperties jwtProperties;

    // 사용자 정보와 토큰 만료 시간을 이용하여 JWT를 생성하는 메서드
    public String generateToken(User user, Duration expiredAt) {
        Date now = new Date();

        // 현재 시간에 만료 시간을 더하여 토큰 만료 시각 계산
        return makeToken(new Date(now.getTime() + expiredAt.toMillis()), user);
    }

    // JWT 토큰 생성 역할을 하는 메서드
    private String makeToken(Date expiry, User user) {
        Date now = new Date();

        // JWT 서명(Signature) 생성에 사용할 비밀키 생성
        SecretKey key = Keys.hmacShaKeyFor(
                jwtProperties.getSecretKey()
                        .getBytes(StandardCharsets.UTF_8)
        );

        return Jwts.builder()                       // JWT 생성 빌더 생성
                .issuer(jwtProperties.getIssuer())  // 토큰 발급자(iss) 설정
                .issuedAt(now)                      // 토큰 발급 시간(iat) 설정
                .expiration(expiry)                 // 토큰 만료 시간(exp) 설정
                .subject(user.getEmail())           // 토큰 주체(사용자 이메일, sub) 설정
                .claim("id", user.getId())    // 사용자 ID를 사용자 정의 클레임으로 추가
                .signWith(key)                      // 비밀키로 토큰에 전자서명(Signature) 생성
                .compact();                         // JWT를 최종 문자열 형태로 생성
    }

    // JWT 토큰 유효성 검증 역할을 하는 메서드
    public boolean validToken(String token) {
        try {
            SecretKey key = Keys.hmacShaKeyFor(
                    jwtProperties.getSecretKey()
                            .getBytes(StandardCharsets.UTF_8)
            );

            Jwts.parser()                       // JWT를 검증하기 위한 파서(parser) 생성
                    .verifyWith(key)            // 비밀키로 토큰이 위조되지 않았는지 검증
                    .build()                    // 설정을 이용한 JWT 파서 객체 생성
                    .parseSignedClaims(token);  // 서명된 JWT를 파싱하고 Claims(토큰 정보)를 추출

            return true;
        } catch (Exception e) { // 복호화 과정에서 에러가 나면 유효하지 않은 토큰
            return false;
        }
    }

    // 토큰 기반으로 인증 정보를 가져오는 역할을 하는 메서드
    public Authentication getAuthentication(String token) {
        Claims claims = getClaims(token);
        Set<SimpleGrantedAuthority> authorities = Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));

        return new UsernamePasswordAuthenticationToken(new org.springframework.security.core.userdetails.User(claims.getSubject
                (), "", authorities), token, authorities);
    }

    // 토큰 기반으로 유저 ID를 가져오는 역할을 하는 메서드
    public Long getUserId(String token) {
        Claims claims = getClaims(token);                       // 토큰의 Payload(Claims) 정보 추출
        return claims.get("id", Long.class);          // Claims에 저장된 사용자 ID 반환
    }

    // JWT 토큰의 Claims(Payload)를 추출하는 역할을 하는 메서드
    private Claims getClaims(String token) {

        // JWT 서명 검증에 사용할 비밀키 생성
        SecretKey key = Keys.hmacShaKeyFor(
                jwtProperties.getSecretKey()
                        .getBytes(StandardCharsets.UTF_8)
        );

        return Jwts.parser()                                    // JWT를 검증하기 위한 파서 생성
                .verifyWith(key)                                // 비밀키를 이용해 토큰의 서명이 위조 및 변조되지 않았는지 검증
                .build()                                        // JWT 파서 객체 생성
                .parseSignedClaims(token)                       // 토큰을 파싱하고 서명을 검증
                .getPayload();                                  // Payload(Claims) 정보 반환
    }
}
