package com.budgettrack.budgettrackapi.Service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.budgettrack.budgettrackapi.Common.APIResponse;
import com.budgettrack.budgettrackapi.DTO.TransactionRequestDTO;
import com.budgettrack.budgettrackapi.Entity.TransactionEntity;
import com.budgettrack.budgettrackapi.Entity.UserEntity;
import com.budgettrack.budgettrackapi.Repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	LoginServiceImpl loginServiceImpl;
	
	public APIResponse saveincometransaction(TransactionRequestDTO transactionRequestDTO) {
		
		APIResponse apiResponse = new APIResponse();
		HashMap<String, Object> resultDataMap = new HashMap<>();
		TransactionEntity transactionEntity = new TransactionEntity();
		
		
		UserEntity user = loginServiceImpl.getUserById(transactionRequestDTO.getUserId());
		if (user == null) {
	        // Handle the case where the user is not found, return an appropriate error response
	        apiResponse.setStatus(HttpStatus.NOT_FOUND.value());
	        apiResponse.setError("User not found");
	        return apiResponse;
	    }
		transactionEntity.setUser(user);
		
		
		transactionEntity.setTransactionDate(transactionRequestDTO.getIncomeDate());
		transactionEntity.setDescription(transactionRequestDTO.getDescription());
		transactionEntity.setAmount(transactionRequestDTO.getAmount());
		transactionEntity.setTransactionType(TransactionEntity.TransactionType.INCOME);
		transactionEntity.setCategory("");
		transactionEntity.setPaymentMethod("");
		transactionEntity.setReceiptUrl("");		
		transactionEntity = transactionRepository.save(transactionEntity);
		
		resultDataMap.put("transactionEntity", transactionEntity);
		System.out.println("transactionEntity : result :" +resultDataMap.get("transactionEntity"));
		
		
		return apiResponse;
	}
}
