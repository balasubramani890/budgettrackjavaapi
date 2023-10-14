package com.budgettrack.budgettrackapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.budgettrack.budgettrackapi.Entity.TransactionEntity;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

	
	
}
