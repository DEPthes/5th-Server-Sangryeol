package com.blog.blogproject.refresh;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    // Refresh Token을 이용하여 저장된 토큰 정보를 조회하는 메서드
    public RefreshToken findByRefreshToken(String refreshToken) {

        // 일치하는 Refresh Token이 있으면 반환하고, 없으면 예외 발생
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected token"));
    }
}