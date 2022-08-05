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

	@GetMapping("/articles/login")
	public String loginForm() {
		return "articles/login";
	}
	
	@GetMapping("/articles/new")
	public String newArticleForm() {
		return "articles/new";
	}

	// api 사용자인증 페이지 추가
	@GetMapping("/articles/api")
	public String apiForm() {
		return "articles/api";
	}

	@PostMapping("/articles/create")
	public String createArticle(ArticleForm form) {
		System.out.println(form.toString());
		return "";
	}

	@PostMapping("/articles/checkID")
	public String checkIDArticle(ArticleForm form) {
		if(form.checkID()){
			return "redirect:mainPage";
		}

		return "redirect:login";
	}

	@GetMapping("/articles/mainPage")
	public String mainPageArticleForm(Model model) {
		model.addAttribute("username", "현서");
		return"/articles/mainPage";
	}
}
