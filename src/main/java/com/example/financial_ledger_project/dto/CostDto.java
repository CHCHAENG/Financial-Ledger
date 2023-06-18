package com.example.financial_ledger_project.dto;

import com.example.financial_ledger_project.entity.Cost;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class CostDto {
	
	private Long id;
	private String login_id;
	private String name;
	private int price;
	private String date;
	private Long category;
	private Long account;

	public static CostDto createCostDto(Cost cost) {
		return new CostDto(
			cost.getId(),
			cost.getLogin_id().getLogin_ID(),
			cost.getName(),
			cost.getPrice(),
			cost.getDate(),
			cost.getCategory().getId(),
			cost.getAccount().getId()
		);
	}

}
