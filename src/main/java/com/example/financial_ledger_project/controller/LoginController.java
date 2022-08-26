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

	public String user_id = null;

	@Autowired
	private loginRepository loginRepository;

	@GetMapping("/articles/login")
	public String loginForm() {
		if(user_id != null) {
			return "redirect:/articles/Mainpage";
		}

		return "articles/login";
	}

	@GetMapping("/articles/signup")
	public String signupPage() {
		return "/articles/signup";
	}

	@PostMapping("/articles/createID")
	public String createID(LoginForm form, RedirectAttributes rttr) {
		login_ID article = form.toEntity(); // aaaa
		log.info(article.toString());

		String id = article.getLogin_ID();
		login_ID target = loginRepository.findById(id).orElse(null);
		if(target != null) {
			rttr.addFlashAttribute("msg", "이 ID를 사용하실 수 없습니다!");
			return "redirect:/articles/signup";
		}

		login_ID saved = loginRepository.save(article);
		log.info(saved.toString());

		return "redirect:/articles/login";

	}

	@PostMapping("/articles/checkID")
	public String checkIDArticle(LoginForm form, RedirectAttributes rttr) {
		login_ID article = form.toEntity();
		String id = article.getLogin_ID();
		login_ID target = loginRepository.findById(id).orElse(null);

		if(target!=null && article.checkID(target)) {
			user_id = target.getLogin_ID();
			return "redirect:/articles/Mainpage";
		}

		rttr.addFlashAttribute("msg", "ID 혹은 비밀번호가 잘못되었습니다!");

		return "redirect:/articles/login";
	}

	@GetMapping("/articles/Costpage")
	public String costPageArticleForm(Model model) {
		if(user_id == null) {
			return "redirect:/articles/login";
		}
		login_ID target = loginRepository.findById(user_id).orElse(null);

		model.addAttribute("user", target);
		return "/articles/costPage";
	}

	@GetMapping("/articles/Calenderpage")
	public String calenderPageArticleForm(Model model) {
		if(user_id == null) {
			return "redirect:/articles/login";
		}
		login_ID target = loginRepository.findById(user_id).orElse(null);

		model.addAttribute("user", target);
		return "/articles/calenderPage";
	}

	@GetMapping("/articles/Mainpage")
	public String mainPageArticleForm(Model model) {
		if(user_id == null) {
			return "redirect:/articles/login";
		}
		login_ID target = loginRepository.findById(user_id).orElse(null);

		model.addAttribute("user", target);
		return "/articles/mainPage";
	}

	@GetMapping("/articles/Incomepage")
	public String incomePageArticleForm(Model model) {
		if(user_id == null) {
			return "redirect:/articles/login";
		}
		login_ID target = loginRepository.findById(user_id).orElse(null);

		model.addAttribute("user", target);
		return "/articles/incomePage";
	}

	@GetMapping("/articles/Mypage")
	public String myPageArticleForm(Model model) {
		if(user_id == null) {
			return "redirect:/articles/login";
		}
		login_ID target = loginRepository.findById(user_id).orElse(null);

		model.addAttribute("user", target);
		return "/articles/myPage";
	}

	@GetMapping("/articles/logout")
	public String logOutForm() {
		user_id = null;
		return "redirect:/articles/login";
	}

}