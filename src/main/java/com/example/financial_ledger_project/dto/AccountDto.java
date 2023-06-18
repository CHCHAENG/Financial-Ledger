package com.example.financial_ledger_project.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class AccountDto {
	
	private Long id;
	private String login_id;
	private String account_number;
	private String bank_name;
	private String nickname;

}
