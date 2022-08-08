package com.example.financial_ledger_project.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.financial_ledger_project.dto.ArticleForm;
import com.example.financial_ledger_project.entity.Article;
import com.example.financial_ledger_project.repository.ArticleRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ArticleApiController {

	@Autowired
	private ArticleRepository articleRepository;

	// GET
	@GetMapping("/api/articles")
	public List<Article> index() {
		return articleRepository.findAll();
	}

	@GetMapping("/api/articles/{id}")
	public Article index(@PathVariable Long id) {
		return articleRepository.findById(id).orElse(null);
	}
	
	// POST
	@PostMapping("/api/articles")
	public ResponseEntity<Article> create(@RequestBody ArticleForm dto) {
		log.info(dto.toString());
		Article saved = articleRepository.save(dto.toEntity());
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}

	// PATCH
	@PatchMapping("/api/articles/{id}")
	public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleForm dto) {
		// 수정용 엔티티 생성
		Article article = dto.toEntity();
		log.info("id: {}, article: {}", id, article.toString());

		Article target = articleRepository.findById(id).orElse(null);

		if(target == null || id != article.getId()){
			log.info("잘못된 요청! id: {}, article: {}", id, article.toString());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}

		target.patch(article);
		Article updated = articleRepository.save(article);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}

	// DELETE
	@DeleteMapping("/api/articles/2")
	public ResponseEntity<Article> delete(@PathVariable Long id) {
		Article target = articleRepository.findById(id).orElse(null);

		if(target == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}

		articleRepository.delete(target);

		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
}
