package com.blog.blogproject.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserRequest {
    private String nickname;    // 유저의 닉네임
    private String email;    // 유저의 이메일
    private String password;    // 유저의 비밀번호
}
