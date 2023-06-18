package com.example.financial_ledger_project.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class IncomeDto {
	
	private Long id;
	private String login_id;
	private String name;
	private int inc_amount;
	private String date;
	private Long category;
	private Long account;

}
