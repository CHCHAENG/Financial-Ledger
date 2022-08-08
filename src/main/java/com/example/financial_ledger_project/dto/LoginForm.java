package com.example.financial_ledger_project.dto;

import com.example.financial_ledger_project.entity.login_ID;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class LoginForm {
	
	private Long id;
	private String login_ID;
	private String login_pw;

	public login_ID toEntity() {
		return new login_ID(null, login_ID, login_pw);
	}

	public boolean checkID() {
		String id = "hyunseo";
		String pw = "1234";

		if(login_ID.equals(id) && login_pw.equals(pw)){
			return true;
		}

		return false;
	}
	
}
