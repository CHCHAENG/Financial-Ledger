package com.example.financial_ledger_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.financial_ledger_project.dto.LoginForm;
import com.example.financial_ledger_project.entity.login_ID;
import com.example.financial_ledger_project.repository.loginRepository;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginController {
	
	@Autowired
	private loginRepository loginRepository;

	@GetMapping("/articles/signup")
	public String signupPage() {
		return "/articles/signup";
	}

	@PostMapping("/articles/createID")
	public String createID(LoginForm form) {
		login_ID article = form.toEntity();
		log.info(article.toString());

		login_ID saved = loginRepository.save(article);
		log.info(saved.toString());

		return "redirect:login";

	}

	@PostMapping("/articles/checkID")
	public String checkIDArticle(LoginForm form, RedirectAttributes rttr) {
		login_ID article = form.toEntity();
		String id = article.getLogin_ID();
		login_ID target = loginRepository.findById(id).orElse(null);

		if(target!=null && article.checkID(target)){
			log.info("if문");
			return "redirect:/articles/Mainpage";
		}

		rttr.addFlashAttribute("msg", "ID 혹은 비밀번호가 잘못되었습니다!");

		return "redirect:/articles/login"; // -> http://localhost:8080/articles/checkID/Mainpage
	}

	@GetMapping("/articles/Mainpage")
	public String mainPageArticleForm(Model model) {
		model.addAttribute("username", "현서");
		return"/articles/mainPage";
	}

}
