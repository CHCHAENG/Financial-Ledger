package com.example.financial_ledger_project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
public class Article {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String title;

	@Column
	private String content;

	public void patch(Article article) {
		if(article.title != null) {
			this.title = article.title;
		}
		if(article.content != null) {
			this.content = article.content;
		}
	}

}
