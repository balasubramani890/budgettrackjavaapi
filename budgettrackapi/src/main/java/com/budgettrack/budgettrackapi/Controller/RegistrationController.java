package com.budgettrack.budgettrackapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<String>  saveRegister(@RequestBody RegistrationSaveDTO registrationSaveDTO)
	{
		System.out.println("registrationSaveDTO DTO:" +registrationSaveDTO.toString());		
		
		try {
		String result = registrationService.addRegistration(registrationSaveDTO);
		return ResponseEntity.ok(result);
		}
		catch(Exception e)
		{
			return ResponseEntity.badRequest().body("Mobile Number Already Exists!!");

		}
	}
}
