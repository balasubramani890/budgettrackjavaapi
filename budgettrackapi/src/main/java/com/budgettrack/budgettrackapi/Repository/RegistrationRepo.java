package com.budgettrack.budgettrackapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.budgettrack.budgettrackapi.Entity.RegistrationEntity;

@EnableJpaRepositories
@Repository
public interface RegistrationRepo extends JpaRepository<RegistrationEntity, Long> {

}
