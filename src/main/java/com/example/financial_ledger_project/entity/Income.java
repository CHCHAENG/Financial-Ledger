package com.example.financial_ledger_project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Income {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private login_ID login_id;

	@Column
	private String name;

	@Column
	private int inc_amount;

	@Column
	private String date;

	@ManyToOne
	private Category category;

	@ManyToOne
	private Account account;

}
