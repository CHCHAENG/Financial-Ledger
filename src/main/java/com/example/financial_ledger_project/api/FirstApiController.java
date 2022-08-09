package com.example.financial_ledger_project.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // RestAPI용 컨트롤러! json을 반환
public class FirstApiController {

	@GetMapping("/api/hello")
	public String hello() {
		return "hello world!";
	}
	
}
