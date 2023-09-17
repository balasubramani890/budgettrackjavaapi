package com.budgettrack.budgettrackapi.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.budgettrack.budgettrackapi.DTO.LoginDTO;
import com.budgettrack.budgettrackapi.DTO.RegistrationSaveDTO;
import com.budgettrack.budgettrackapi.Entity.RegistrationEntity;
import com.budgettrack.budgettrackapi.Repository.RegistrationRepo;

import jakarta.transaction.Transactional;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationRepo registrationRepo;


	@Override
	public boolean addRegistration(RegistrationSaveDTO registrationSaveDTO) {
		
		try {			
		if (!registrationRepo.findByMobileNumber(registrationSaveDTO.getCustomerMobile())) {
			RegistrationEntity registrationEntity = new RegistrationEntity();
			registrationEntity.setRegisterDate(LocalDate.now());
			registrationEntity.setCustomerName(registrationSaveDTO.getCustomerName());
			registrationEntity.setCustomerMobile(registrationSaveDTO.getCustomerMobile());
			registrationEntity.setPassword(registrationSaveDTO.getPassword());
			registrationRepo.save(registrationEntity);
			return true;			
		}
		else
		{			
			return false;
		}
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	@Override
	public long loginService(LoginDTO loginDTO)
	{
		try {
		if(registrationRepo.validLogin(loginDTO.getCustomerMobile(), loginDTO.getPassword()))
		{
			RegistrationEntity registrationEntity = new RegistrationEntity();
			Long customerId =  registrationRepo.loginAccept(loginDTO.getCustomerMobile(), loginDTO.getPassword());
			return customerId;
		}
		else
		{
			return 0;
		}
		}
		catch(Exception e)
		{
			return -1L;
		}
	}

}

