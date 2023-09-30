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
	public long loginService(String customerMobile, String password)
	{
		try {
		if(registrationRepo.validLogin(customerMobile, password))
		{
			RegistrationEntity registrationEntity = new RegistrationEntity();
			Long customerId =  registrationRepo.loginAccept(customerMobile, password);
			return customerId;
		}
		else
		{
			return 0;
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return -1L;
		}
	}
	
	
	public String forgetPasswordService(String customerMobile)
	{
		try {
			if(registrationRepo.findByMobileNumber(customerMobile))
			{
				RegistrationEntity registrationEntity = new RegistrationEntity();
				String password =  registrationRepo.forgetPasswordRepo(customerMobile);
				return password;
			}
			else
			{
				return "Mobile Number not available";
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return "Exception : forgetPasswordService: " +e;
			}
	}

}

