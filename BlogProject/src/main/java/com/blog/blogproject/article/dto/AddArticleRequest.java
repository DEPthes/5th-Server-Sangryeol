package com.blog.blogproject.article.dto;

import com.blog.blogproject.article.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor  // 기본 생성자 생성
@AllArgsConstructor // 모든 필드를 매개변수로 받는 생성자 생성
@Getter             // 모든 필드의 getter 메서드 생성
public class AddArticleRequest {

    private String title;   // 게시글 제목
    private String content; // 게시글 내용

    // 요청 DTO를 Article 엔티티로 변환
    public Article toEntity() {
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}
