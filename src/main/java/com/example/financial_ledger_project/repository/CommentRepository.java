package com.example.financial_ledger_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.financial_ledger_project.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
	@Query(value =
            "SELECT * " +
            "FROM comment " +
            "WHERE article_id = :articleId",
            nativeQuery = true)
	List<Comment> findByArticleId(@Param("articleId") Long articleId);

	List<Comment> findByNickname(@Param("nickname") String nickname);
	
}
