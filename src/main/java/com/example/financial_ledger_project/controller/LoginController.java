package com.example.financial_ledger_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.financial_ledger_project.dto.LoginForm;
import com.example.financial_ledger_project.entity.login_ID;
import com.example.financial_ledger_project.repository.loginRepository;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginController {
	
	@Autowired
	private loginRepository loginRepository;

	@PostMapping("/articles/checkID")
	public String checkIDArticle(LoginForm form) {
		login_ID article = form.toEntity();
		log.info(article.toString());

		login_ID saved = loginRepository.save(article);
		log.info(saved.toString());

		if(form.checkID()){
			return "redirect:Mainpage";
		}

		return "redirect:login";
	}

	@GetMapping("/articles/Mainpage")
	public String mainPageArticleForm(Model model) {
		model.addAttribute("username", "현서");
		return"/articles/mainPage";
	}

}
