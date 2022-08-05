package com.example.financial_ledger_project.dto;

public class ArticleForm {
	
	private String ID;
	private String Password;
	private String name;


	public ArticleForm(String ID, String Password, String name) {
		this.ID = ID;
		this.Password = Password;
		this.name = name;
	}

	@Override
	public String toString() {
		return "ArticleForm{" +
                "ID='" + ID + '\'' +
                ", Password='" + Password + '\'' +
				", name = '" + name + '\'' +
                '}';
	}

	public boolean checkID() {
		String id = ID;
		String pw = Password;

		if(ID.equals(id) && Password.equals(pw)){
			return true;
		}

		return false;
	}
	
}
