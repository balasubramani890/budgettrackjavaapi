package com.budgettrack.budgettrackapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.budgettrack.budgettrackapi.Common.APIResponse;
import com.budgettrack.budgettrackapi.DTO.RequestMeta;
import com.budgettrack.budgettrackapi.DTO.TransactionRequestDTO;
import com.budgettrack.budgettrackapi.DTO.TransactionUpdateDTO;
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

	@PostMapping("/saveincometransaction")
	public ResponseEntity<APIResponse> saveIncomeTransaction(@RequestBody TransactionRequestDTO transactionRequestDTO) {
		System.out.println("TransactionController Class : saveIncomeTransaction Method : Started");
		APIResponse apiResponse = new APIResponse();
		transactionRequestDTO.setUserId(requestMeta.getUserId());
		try {
			apiResponse = transactionService.saveIncomeTransaction(transactionRequestDTO);

			return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		}

		catch (Exception e) {
			apiResponse.setError(e.getMessage());
			return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		}

	}
	
	
	

	@PostMapping("/updateincometransaction")
	public ResponseEntity<APIResponse> updateIncomeTransaction(@RequestBody TransactionUpdateDTO transactionUpdateDTO) {
		APIResponse apiResponse = new APIResponse();
		transactionUpdateDTO.setUserId(requestMeta.getUserId());
		try {
			apiResponse = transactionService.updateIncomeTransaction(transactionUpdateDTO);

			return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		}

		catch (Exception e) {
			apiResponse.setError(e.getMessage());
			return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		}

	}
	
		
	
	@PostMapping("/saveexpensetransaction")
	public ResponseEntity<APIResponse> saveExpenseTransaction(@RequestBody TransactionRequestDTO transactionRequestDTO) {
		APIResponse apiResponse = new APIResponse();
		transactionRequestDTO.setUserId(requestMeta.getUserId());
		try {
			apiResponse = transactionService.saveExpenseTransaction(transactionRequestDTO);

			return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		}

		catch (Exception e) {
			apiResponse.setError(e.getMessage());
			return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		}

	}
	
	
	@PostMapping("/updateexpensetransaction")
	public ResponseEntity<APIResponse> updateExpenseTransaction(@RequestBody TransactionUpdateDTO transactionUpdateDTO) {
		APIResponse apiResponse = new APIResponse();
		transactionUpdateDTO.setUserId(requestMeta.getUserId());
		try {
			apiResponse = transactionService.updateExpenseTransaction(transactionUpdateDTO);

			return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		}

		catch (Exception e) {
			apiResponse.setError(e.getMessage());
			return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		}
	}
	


}
