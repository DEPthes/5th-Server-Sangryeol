package com.blog.blogproject.auth;

import com.blog.blogproject.auth.dto.CreateAccessTokenRequest;
import com.blog.blogproject.config.jwt.JwtFactory;
import com.blog.blogproject.global.jwt.JwtProperties;
import com.blog.blogproject.refresh.RefreshToken;
import com.blog.blogproject.refresh.RefreshTokenRepository;
import com.blog.blogproject.user.User;
import com.blog.blogproject.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import tools.jackson.databind.ObjectMapper;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class TokenApiControllerTest {

    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    JwtProperties jwtProperties;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RefreshTokenRepository refreshTokenRepository;

    @BeforeEach
    public void mockMvcSetup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        userRepository.deleteAll();
    }

    @DisplayName("createNewAccessToken: 새로운 액세스 토큰을 발급한다.")
    @Test
    public void createNewAccessToken() throws Exception {
        // given
        final String url = "/api/token";

        // 테스트용 사용자 저장
        User testUser = userRepository.save(User.builder()
                .nickname("nickname")
                .email("user@gmail.com")
                .password("test")
                .build());

        // 테스트용 Refresh Token 생성
        String refreshToken = JwtFactory.builder()
                .claims(Map.of("id", testUser.getId()))
                .build()
                .createToken(jwtProperties);

        // 생성한 Refresh Token을 DB에 저장
        refreshTokenRepository.save(new RefreshToken(testUser.getId(), refreshToken));

        // 액세스 토큰 재발급 요청 객체 생성
        CreateAccessTokenRequest request = new CreateAccessTokenRequest();
        request.setRefreshToken(refreshToken);

        // 요청 객체를 JSON 문자열로 변환
        final String requestBody = objectMapper.writeValueAsString(request);

        // when
        // 액세스 토큰 재발급 API 호출
        ResultActions resultActions = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestBody));

        // then
        // HTTP 상태 코드가 201(Created)인지 확인
        // accessToken이 정상적으로 발급되었는지 확인
        resultActions
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.accessToken").isNotEmpty());
    }
}