package com.budgettrack.budgettrackapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.budgettrack.budgettrackapi.Common.APIResponse;
import com.budgettrack.budgettrackapi.DTO.RequestMeta;
import com.budgettrack.budgettrackapi.DTO.TransactionRequestDTO;
import com.budgettrack.budgettrackapi.Service.TransactionService;

@RestController
@CrossOrigin
@RequestMapping("api")
public class TransactionController {
	
	private final RequestMeta requestMeta;
	
	@Autowired
	TransactionService transactionService;
	
    public TransactionController(RequestMeta requestMeta) {
        this.requestMeta = requestMeta;
    }
	
	//	use the below method approach to get the session id(user id)
	/*
	 * public ResponseEntity<?> yourControllerMethod(@RequestBody
	 * TransactionRequestDTO requestDTO) { // Extract userId from requestMeta and
	 * set it in the DTO Long userId = requestMeta.getUserId();
	 * requestDTO.setUserId(userId);
	 * 
	 * // Use requestDTO in your logic // ... }
	 */
	

	@PostMapping ("/saveincometransaction")
	public ResponseEntity<APIResponse> saveincometransaction(@RequestBody TransactionRequestDTO transactionRequestDTO)	
	{
		transactionRequestDTO.setUserId(requestMeta.getUserId());
		
		APIResponse apiResponse = transactionService.saveincometransaction(transactionRequestDTO);
		
		
		return ResponseEntity
				.status(apiResponse.getStatus())
				.body(apiResponse);
		
	}
	
}
