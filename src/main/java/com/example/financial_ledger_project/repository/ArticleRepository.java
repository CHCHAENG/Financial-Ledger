package com.example.financial_ledger_project.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import com.example.financial_ledger_project.entity.Article;

public interface ArticleRepository extends CrudRepository<Article, Long> {
	@Override
	ArrayList<Article> findAll();
}
