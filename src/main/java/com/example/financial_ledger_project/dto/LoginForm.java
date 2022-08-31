package com.example.financial_ledger_project.dto;

import com.example.financial_ledger_project.entity.login_ID;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class LoginForm {
	
	private String login_ID;
	private String login_pw;
	private String login_name;
	private int limit_amount;

	public login_ID toEntity() {
		return new login_ID(login_ID, login_pw, login_name, limit_amount);
	}

}
