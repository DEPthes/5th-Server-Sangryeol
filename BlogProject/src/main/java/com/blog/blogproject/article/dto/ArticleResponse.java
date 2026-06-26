package com.blog.blogproject.article.dto;

import com.blog.blogproject.article.Article;
import lombok.Getter;

@Getter
public class ArticleResponse {

    private final String title;
    private final String content;

    // Article 엔티티를 응답 DTO로 변환
    public ArticleResponse(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
