package com.example.financial_ledger_project.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.financial_ledger_project.entity.login_ID;

public interface loginRepository extends CrudRepository<login_ID, String> {

	
}
