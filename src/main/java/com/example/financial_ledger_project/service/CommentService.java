package com.example.financial_ledger_project.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.financial_ledger_project.dto.CommentDto;
import com.example.financial_ledger_project.entity.Article;
import com.example.financial_ledger_project.entity.Comment;
import com.example.financial_ledger_project.repository.ArticleRepository;
import com.example.financial_ledger_project.repository.CommentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CommentService {
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private ArticleRepository articleRepository;

	public List<CommentDto> comments(Long articleId) {
		// // 조회: 댓글 목록
		// List<Comment> comments = commentRepository.findByArticleId(articleId);

		// // 변환: 엔티티 -> DTO
		// List<CommentDto> dtos = new ArrayList<CommentDto>();
		// for (int i=0; i<comments.size(); i++) {
		// 	Comment c = comments.get(i);
		// 	CommentDto dto = CommentDto.createCommentDto(c);
		// 	dtos.add(dto);
		// }

		// // 반환
		// return dtos;

		log.info("id = " + articleId);
		
		return commentRepository.findByArticleId(articleId)
				.stream()
				.map(comment -> CommentDto.createCommentDto(comment))
				.collect(Collectors.toList());
	}

	@Transactional
	public CommentDto create(Long articleId, CommentDto dto) {
		// 게시글 조회 및 예외 발생
		Article article = articleRepository.findById(articleId).orElseThrow(() -> new IllegalArgumentException("댓글 생성 실패! 대상 게시글이 없습니다."));

		// 댓글 엔티티 생성
		Comment comment = Comment.createComment(dto, article);
		log.info(comment.toString());

		// 댓글 엔티티를 DB로 저장
		Comment created = commentRepository.save(comment);

		//DTo로 변경하여 반환
		return CommentDto.createCommentDto(created);
	}

	@Transactional
	public CommentDto update(Long id, CommentDto dto) {
		// 댓글 조회 및 예외 발생
		Comment target = commentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("댓글 수정 실패! 대상 댓글이 없습니다."));

		// 댓글 수정
		target.patch(dto);

		// DB로 갱신
		Comment updated = commentRepository.save(target);

		// 댓글 엔티티를 DTO로 변환 및 반환
		return CommentDto.createCommentDto(updated);
	}

	@Transactional
	public CommentDto delete(Long id) {
		// 댓글 조회(및 예외 발생)
		Comment target = commentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("댓글 삭제 실패! 대상이 없습니다."));

		// 댓글 DB에서 삭제
		commentRepository.delete(target);

		// 삭제 댓글을 DTO로 반환
		return CommentDto.createCommentDto(target);
	}
	
}
