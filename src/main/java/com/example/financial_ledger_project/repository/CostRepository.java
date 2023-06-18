package com.example.financial_ledger_project.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.financial_ledger_project.entity.Cost;

public interface CostRepository extends CrudRepository<Cost, Long> {
	
}
