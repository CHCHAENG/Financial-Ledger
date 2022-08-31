package com.example.financial_ledger_project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class login_ID {
	
	@Id
	private String login_ID;

	@Column
	private String login_pw;
	
	@Column
	private String login_name;

	@Column
	private int limit_amount;

	public boolean checkID(login_ID target) {
		String pw = target.login_pw;

		if(this.login_pw.equals(pw)){
			return true;
		}

		return false;
	}
	
}
