package com.blog.blogproject.auth;

import com.blog.blogproject.auth.dto.CreateAccessTokenRequest;
import com.blog.blogproject.auth.dto.CreateAccessTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TokenApiController {
    private final TokenService tokenService;

    // Refresh Token을 이용하여 새로운 Access Token을 발급하는 API
    @PostMapping("/api/token")
    public ResponseEntity<CreateAccessTokenResponse> createNewAccessToken(
            @RequestBody CreateAccessTokenRequest request) {

        // Refresh Token을 검증한 후 새로운 Access Token 생성
        String newAccessToken = tokenService.createNewAccessToken(request.getRefreshToken());

        // 생성된 Access Token과 함께 HTTP 201(Created) 응답 반환
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new CreateAccessTokenResponse(newAccessToken));
    }
}