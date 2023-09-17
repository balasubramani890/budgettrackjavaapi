package com.budgettrack.budgettrackapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.budgettrack.budgettrackapi.DTO.LoginDTO;
import com.budgettrack.budgettrackapi.DTO.RegistrationSaveDTO;
import com.budgettrack.budgettrackapi.Service.RegistrationService;

@RestController
@CrossOrigin
@RequestMapping("api/registration")
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@PostMapping(path="/save")
	public boolean saveRegister(@RequestBody RegistrationSaveDTO registrationSaveDTO)
	{
		System.out.println("registrationSaveDTO DTO:" +registrationSaveDTO.toString());		
		
		try {
		boolean result = registrationService.addRegistration(registrationSaveDTO);
		return result;
		}
		catch(Exception e)
		{
			return false;

		}
	}
	
	
	@GetMapping(path="/login")
	public Long loginControl(@RequestBody LoginDTO loginDTO)
	{
		System.out.println("Login");
		
		try {
			
			Long customerId = registrationService.loginService(loginDTO);
			
			return customerId;
			
		}
		
		catch(Exception e)
		{
			return -1L;
		}
	}
	
}
