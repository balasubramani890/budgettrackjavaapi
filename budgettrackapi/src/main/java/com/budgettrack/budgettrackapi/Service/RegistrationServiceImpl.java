package com.budgettrack.budgettrackapi.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.budgettrack.budgettrackapi.DTO.RegistrationSaveDTO;
import com.budgettrack.budgettrackapi.Entity.RegistrationEntity;
import com.budgettrack.budgettrackapi.Repository.RegistrationRepo;

import jakarta.transaction.Transactional;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationRepo registrationRepo;


	@Override
	public String addRegistration(RegistrationSaveDTO registrationSaveDTO) {
		
		try {			
		if (registrationRepo.findByMobileNumber(registrationSaveDTO.getCustomerMobile())) {
			return "Mobile Number Already Exists!!";
		}
		else
		{			
			RegistrationEntity registrationEntity = new RegistrationEntity();
			registrationEntity.setRegisterDate(LocalDate.now());
			registrationEntity.setCustomerName(registrationSaveDTO.getCustomerName());
			registrationEntity.setCustomerMobile(registrationSaveDTO.getCustomerMobile());
			registrationEntity.setPassword(registrationSaveDTO.getPassword());
			registrationRepo.save(registrationEntity);
			return "User Added Successfully!!";
		}
		}
		catch(Exception e)
		{
			return "Kindly Check: " +e;
		}
	}

}

