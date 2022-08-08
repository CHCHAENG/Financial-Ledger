package com.example.financial_ledger_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.financial_ledger_project.entity.Article;
import com.example.financial_ledger_project.repository.ArticleRepository;

@Service // 서비스 선언! (서비스 객체를 스프링부트에 생성)
public class ArticleService {
	@Autowired
	private ArticleRepository articlerepository;

	public List<Article> index() {
		return articlerepository.findAll();
	}

	public Article show(Long id) {
		return articlerepository.findById(id).orElse(null);
	}
}
