package com.example.financial_ledger_project.objectmapper;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@NoArgsConstructor
public class Burger {
	private String name;
	private int price;
	private List<String> ingredients;
}
