package com.budgettrack.budgettrackapi.Service;

import com.budgettrack.budgettrackapi.Common.APIResponse;
import com.budgettrack.budgettrackapi.DTO.ForgetPasswordReqDTO;
import com.budgettrack.budgettrackapi.DTO.LoginRequestDTO;
import com.budgettrack.budgettrackapi.DTO.SignUpRequestDTO;
import com.budgettrack.budgettrackapi.Entity.UserEntity;

public interface LoginService {
	
	APIResponse signUp(SignUpRequestDTO signUpRequestDTO);
	APIResponse login(LoginRequestDTO loginRequestDTO);
	APIResponse forgetPasswordService(ForgetPasswordReqDTO forgetPasswordReqDTO);

}
