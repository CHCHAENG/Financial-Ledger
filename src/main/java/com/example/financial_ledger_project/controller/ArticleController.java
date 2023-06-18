package com.example.financial_ledger_project.controller;

import com.example.financial_ledger_project.FinancialLedgerProjectApplication;
import com.example.financial_ledger_project.dto.TokenRequestDto;
import com.example.financial_ledger_project.dto.TokenResponseDto;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.financial_ledger_project.dto.ArticleForm;

@Controller
public class ArticleController {

	@GetMapping("/articles/new")
	public String newArticleForm() {
		return "articles/new";
	}
	
	@PostMapping("/articles/create")
	public String createArticle(ArticleForm form) {
		log.info(form.toString());

		Article article = form.toEntity();
		log.info(article.toString());

		Article saved = articleRepository.save(article);
		log.info(saved.toString());

		return "redirect:/articles/" + saved.getId();
	}

	@GetMapping("/articles/{id}")
	public String show(@PathVariable Long id, Model model) {
		log.info("id = " + id);
		Article articleEntity = articleRepository.findById(id).orElse(null);
		List<CommentDto> commentDtos = commentService.comments(id);

		log.info(commentDtos.toString());

		model.addAttribute("article", articleEntity);
		model.addAttribute("commentDtos", commentDtos);

		return "articles/show";
	}

	// api 사용자인증 페이지 추가
	@GetMapping("/articles/api")
	public String apiForm() {
		return "articles/api";
	}

	@GetMapping("/articles/{id}/edit")
	public String edit(@PathVariable Long id, Model model) {
		Article articleEntity = articleRepository.findById(id).orElse(null);
		log.info(articleEntity.toString());

		model.addAttribute("article", articleEntity);

		return "articles/edit";
	}

	@PostMapping("/articles/update")
	public String update(ArticleForm form) {
		log.info(form.toString());
		
		Article articleEntity = form.toEntity();
		log.info(articleEntity.toString());

		Article target = articleRepository.findById(articleEntity.getId()).orElse(null);

		if(target!=null) {
			articleRepository.save(articleEntity);
		}

		return "redirect:/articles/" + articleEntity.getId();
	}

	@GetMapping("/articles/mainPage")
	public String mainPageArticleForm(Model model) {
		model.addAttribute("username", "현서");
		return"/articles/mainPage";
	}
}
