package com.example.financial_ledger_project.dto;

public class ArticleForm {
	
	private String ID;
	private String password;

	public ArticleForm(String ID, String password) {
		this.ID = ID;
		this.password = password;
	}

	@Override
	public String toString() {
		return "ArticleForm{" +
                "ID='" + ID + '\'' +
                ", password='" + password + '\'' +
                '}';
	}

	public boolean checkID() {
		String id = "hyunseo";
		String pw = "1234";

		if(ID.equals(id) && password.equals(pw)){
			return true;
		}

		return false;
	}
	
}
