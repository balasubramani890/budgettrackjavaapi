package com.budgettrack.budgettrackapi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.budgettrack.budgettrackapi.DTO.RegistrationSaveDTO;
import com.budgettrack.budgettrackapi.Entity.RegistrationEntity;
import com.budgettrack.budgettrackapi.Repository.RegistrationRepo;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationRepo registrationRepo;
	
	@Override
	public Long addRegistration(RegistrationSaveDTO registrationSaveDTO) {
		
		
		RegistrationEntity registrationEntity = new RegistrationEntity(null, registrationSaveDTO.getCustomerName(),
				registrationSaveDTO.getCustomerMobile(), registrationSaveDTO.getPassword());
		
		
		registrationRepo.save(registrationEntity);
		return null;
	}

}
