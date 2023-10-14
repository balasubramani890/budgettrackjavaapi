package com.budgettrack.budgettrackapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.budgettrack.budgettrackapi.Common.APIResponse;
import com.budgettrack.budgettrackapi.DTO.ForgetPasswordReqDTO;
import com.budgettrack.budgettrackapi.DTO.LoginRequestDTO;
import com.budgettrack.budgettrackapi.DTO.SignUpRequestDTO;
import com.budgettrack.budgettrackapi.Service.LoginServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("api")
public class LoginController {
	
	@Autowired
	LoginServiceImpl loginServiceImpl;
	
	@PostMapping ("/signup")
	public ResponseEntity<APIResponse> signUp(@RequestBody SignUpRequestDTO signUpRequestDTO)	
	{	
		APIResponse apiResponse = loginServiceImpl.signUp(signUpRequestDTO);
		return ResponseEntity
				.status(apiResponse.getStatus())
				.body(apiResponse);
	}
	
	@PostMapping ("/login")
	public ResponseEntity<APIResponse> login(@RequestBody LoginRequestDTO loginRequestDTO)	
	{		
		APIResponse apiResponse = loginServiceImpl.login(loginRequestDTO);
		return ResponseEntity
				.status(apiResponse.getStatus())
				.body(apiResponse);
	}
		
	@PostMapping ("/forgetpassword")	
	public ResponseEntity<APIResponse> forgetpassword(@RequestBody ForgetPasswordReqDTO forgetPasswordReqDTO)
	{
		APIResponse apiResponse = loginServiceImpl.forgetPasswordService(forgetPasswordReqDTO);
		return ResponseEntity
				.status(apiResponse.getStatus())
				.body(apiResponse);
		
	}

}
