package com.blog.blogproject.article;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


// 게시글 엔티티의 CRUD 기능을 제공하는 Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    // Pageable 정보를 이용해 페이징이 적용된 게시글 목록 조회
    Page<Article> findAll(Pageable pageable);
}
