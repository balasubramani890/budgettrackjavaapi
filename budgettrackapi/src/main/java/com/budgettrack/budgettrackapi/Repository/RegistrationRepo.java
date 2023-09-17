package com.budgettrack.budgettrackapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.budgettrack.budgettrackapi.Entity.RegistrationEntity;

@EnableJpaRepositories
@Repository
public interface RegistrationRepo extends JpaRepository<RegistrationEntity, Long> {
	
	@Query(value ="SELECT CASE WHEN COUNT(e.customerMobile) > 0 THEN TRUE ELSE FALSE END FROM RegistrationEntity e WHERE e.customerMobile = ?1")
	boolean findByMobileNumber(String mobileNumber);
	
	@Query(value ="SELECT CASE WHEN COUNT(e.id) > 0 THEN TRUE ELSE FALSE END FROM RegistrationEntity e WHERE e.customerMobile = ?1 and e.password = ?2")
	boolean validLogin(String mobileNumber, String password);
	
	@Query(value ="SELECT customerId FROM RegistrationEntity e WHERE e.customerMobile = ?1 and e.password = ?2")
	Long loginAccept(String mobileNumber, String password);
	
	

}
