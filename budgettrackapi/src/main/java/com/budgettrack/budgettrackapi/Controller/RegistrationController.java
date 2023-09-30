package com.budgettrack.budgettrackapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
		System.out.println("saveRegister");		
		
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
	public Long loginControl(@RequestParam("customerMobile") String customerMobile, @RequestParam("password") String password)
	{
		System.out.println("login");
		
		try {
			
			Long customerId = registrationService.loginService(customerMobile, password);
			
			return customerId;
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			return -1L;
		}
	}
	
	
	@GetMapping(path="/forgetpassword")	
	public String forgetpassword(@RequestParam("customerMobile") String customerMobile)
	{
		System.out.println("forget password");
		
		try {
			
			String password = registrationService.forgetPasswordService(customerMobile);		
			return password;			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			return "Exception : forgetpassword: " +e;
		}
	}
	
}
