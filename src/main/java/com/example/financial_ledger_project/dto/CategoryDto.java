package com.example.financial_ledger_project.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class CategoryDto {
	
	private Long id;
	private String login_id;
	private String category;
	private int amount;
	private int limit;

}
