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

}
