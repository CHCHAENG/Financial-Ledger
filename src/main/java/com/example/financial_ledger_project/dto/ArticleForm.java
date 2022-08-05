package com.example.financial_ledger_project.dto;

public class ArticleForm {
	
	private String title;
	private String content;

	public ArticleForm(String title, String content) {
		this.title = title;
		this.content = content;
	}

	@Override
	public String toString() {
		return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
	}

	public boolean checkID() {
		String id = "hyunseo";
		String pw = "1234";

		if(title.equals(id) && content.equals(pw)){
			return true;
		}

		return false;
	}
	
}
