package com.blog.blogproject.article;

import org.springframework.data.jpa.repository.JpaRepository;

// 게시글 엔티티의 CRUD 기능을 제공하는 Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
