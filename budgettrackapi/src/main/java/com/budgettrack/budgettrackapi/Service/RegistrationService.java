package com.budgettrack.budgettrackapi.Service;


import com.budgettrack.budgettrackapi.DTO.RegistrationSaveDTO;



public interface RegistrationService {

	boolean addRegistration(RegistrationSaveDTO registrationSaveDTO);
	long loginService(String customerMobile, String password);
	
	

}
