package com.blog.blogproject.article;

import com.blog.blogproject.article.dto.AddArticleRequest;
import com.blog.blogproject.article.dto.UpdateArticleRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor    // final 필드를 매개변수로 받는 생성자 생성
@Service                    // 서비스 계층의 스프링 빈으로 등록
public class ArticleService {

    private final ArticleRepository articleRepository;

    // 블로그 글 추가 메서드
    public Article addArticle(AddArticleRequest request) {
        return articleRepository.save(request.toEntity());
    }

    // 블로그 글 목록 조회 메서드
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    // 블로그 글 조회 메서드
    public Article findById(long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    // 블로그 글 삭제 메서드
    public void delete(long id) {
        articleRepository.deleteById(id);
    }

    // 블로그 글 수정 메서드
    @Transactional
    public Article updateArticle(long id, UpdateArticleRequest request) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}