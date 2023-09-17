package com.budgettrack.budgettrackapi.Service;


import com.budgettrack.budgettrackapi.DTO.LoginDTO;
import com.budgettrack.budgettrackapi.DTO.RegistrationSaveDTO;



public interface RegistrationService {

	boolean addRegistration(RegistrationSaveDTO registrationSaveDTO);
	long loginService(LoginDTO loginDTO);
	
	

}
