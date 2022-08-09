package com.example.financial_ledger_project.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.financial_ledger_project.entity.login_ID;

public interface loginRepository extends CrudRepository<login_ID, String> {

	Optional<login_ID> findById(String id);
	
}
