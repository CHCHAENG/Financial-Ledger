package com.example.financial_ledger_project.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.financial_ledger_project.dto.ArticleForm;
import com.example.financial_ledger_project.entity.Article;
import com.example.financial_ledger_project.repository.ArticleRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service // 서비스 선언! (서비스 객체를 스프링부트에 생성)
public class ArticleService {
	@Autowired
	private ArticleRepository articleRepository;

	public List<Article> index() {
		return articleRepository.findAll();
	}

	public Article show(Long id) {
		return articleRepository.findById(id).orElse(null);
	}

	public Article create(ArticleForm dto) {
		Article article = dto.toEntity();
		if(article.getId() != null) {
			return null;
		}
		
		return articleRepository.save(article);
	}

	public Article update(Long id, ArticleForm dto) {
		// 수정용 엔티티 생성
		Article article = dto.toEntity();
		log.info("id: {}, article: {}", id, article.toString());

		// 대상 엔티티 찾기
		Article target = articleRepository.findById(id).orElse(null);

		// 잘못된 요청 처리
		if(target == null || id != article.getId()){
			log.info("잘못된 요청! id: {}, article: {}", id, article.toString());
			return null;
		}

		target.patch(article);
		Article updated = articleRepository.save(target);

		return updated;
	}

	public Article delete(Long id) {
		// 대상 엔티티 찾기
		Article target = articleRepository.findById(id).orElse(null);

		// 잘못된 요청 처리
		if(target == null) {
			return null;
		}

		articleRepository.delete(target);

		return target;
	}

	@Transactional // 해당 메소드를 트랜젝션으로 묶음!
	public List<Article> createArticles(List<ArticleForm> dtos) {
		// dto 묶음을 entity 묶음으로 변환
		// List<Article> articleList = dtos.stream().map(dto -> dto.toEntity()).collect(Collectors.toList());
		List<Article> articleList = new ArrayList<>();
		for (int i=0; i<dtos.size(); i++) {
			ArticleForm dto = dtos.get(i);
			Article entity = dto.toEntity();
			articleList.add(entity);
		}

		// entity 묶음을 DB로 저장
		// articleList.stream().forEach(article -> articleRepository.save(article));
		for (int i=0; i<articleList.size(); i++) {
			Article article = articleList.get(i);
			articleRepository.save(article);
		}

		// 강제 예외 발생
		articleRepository.findById(-1L).orElseThrow(() -> new IllegalArgumentException("결제 실패!"));

		// 결과값 반환
		return articleList;
	}

}
