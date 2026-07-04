package com.blog.blogproject.auth;

import com.blog.blogproject.global.jwt.TokenProvider;
import com.blog.blogproject.refresh.RefreshTokenService;
import com.blog.blogproject.user.User;
import com.blog.blogproject.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;

@RequiredArgsConstructor
@Service
public class TokenService {

    private final TokenProvider tokenProvider;
    private final RefreshTokenService refreshTokenService;
    private final UserService userService;

    // Refresh Token을 이용하여 새로운 Access Token을 생성하는 메서드
    public String createNewAccessToken(String refreshToken) {
        // 토큰 유효성 검사에 실패하면 예외 발생
        if(!tokenProvider.validToken(refreshToken)) {
            throw new IllegalArgumentException("Unexpected token");
        }

        // Refresh Token으로 사용자 ID를 조회
        Long userId = refreshTokenService.findByRefreshToken(refreshToken).getUserId();

        // 사용자 ID를 이용해 사용자 정보 조회
        User user = userService.findById(userId);

        // 조회한 사용자 정보를 기반으로 새로운 Access Token 생성 및 반환
        return tokenProvider.generateToken(user, Duration.ofHours(2));
    }
}
