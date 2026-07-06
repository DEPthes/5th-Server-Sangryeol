package com.blog.blogproject.global.jwt;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties("jwt") // 자바 클래스에 프로퍼티값을 가져와서 사용하는 어노테이션
public class JwtProperties {

    // JWT를 발급한 주체(발급자)를 나타내는 값(iss 클레임)
    private String issuer;

    // JWT 서명(Signature) 생성 및 검증에 사용하는 비밀 키
    private String secretKey;
}
