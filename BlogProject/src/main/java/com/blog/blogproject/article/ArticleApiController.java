package com.blog.blogproject.article;

import com.blog.blogproject.article.dto.AddArticleRequest;
import com.blog.blogproject.article.dto.ArticleResponse;
import com.blog.blogproject.article.dto.UpdateArticleRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor    // final 필드를 매개변수로 받는 생성자 생성
@RestController             // REST API 컨트롤러로 등록
@RequestMapping("/api/articles")    // 공통 URL 설정
public class ArticleApiController {

    private final ArticleService articleService;

    // 게시글 등록 API
    @PostMapping
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        Article savedArticle = articleService.addArticle(request);

        // HTTP 상태 코드 201(Created)와 함께 저장된 게시글 반환
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }

    // 게시글 목록 조회 API
    @GetMapping
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {

        // 조회한 게시글 목록을 응답 DTO로 변환
        List<ArticleResponse> articles = articleService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();

        // HTTP 200(OK)와 함께 게시글 목록 반환
        return ResponseEntity.ok()
                .body(articles);
    }

    // 게시글 단건 조회 API
    @GetMapping("/{id}")
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable("id") long id) {

        // URL의 id에 해당하는 게시글 조회
        Article article = articleService.findById(id);

        // 조회한 게시글을 응답 DTO로 변환하여 반환
        return ResponseEntity.ok()
                .body(new ArticleResponse(article));
    }

    // 게시글 삭제 API
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable("id") long id) {

        // id에 해당하는 게시글 삭제
        articleService.delete(id);

        // HTTP 200(OK) 상태 코드만 반환
        return ResponseEntity.ok()
                .build();
    }

    // 게시글 수정 API
    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable("id") long id, @RequestBody UpdateArticleRequest request) {
        Article updatedArticle = articleService.updateArticle(id, request);

        return ResponseEntity.ok()
                .body(updatedArticle);
    }
}