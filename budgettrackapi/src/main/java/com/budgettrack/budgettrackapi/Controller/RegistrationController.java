package com.budgettrack.budgettrackapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public String saveRegister(@RequestBody RegistrationSaveDTO registrationSaveDTO)
	{
		Long id = registrationService.addRegistration(registrationSaveDTO);
		return "";
	}
}
