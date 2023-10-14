package com.budgettrack.budgettrackapi.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionRequestDTO {
	
	private Long userId;
	private String incomeDate;
	private String description;
	private BigDecimal amount;
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getIncomeDate() {
		return incomeDate;
	}
	public void setIncomeDate(String incomeDate) {
		this.incomeDate = incomeDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	
	
	
}
