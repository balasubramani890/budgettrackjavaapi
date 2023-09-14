package com.budgettrack.budgettrackapi.Entity;


import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table (name="Register")
public class RegistrationEntity {
	
	@Id	
	@Column(name = "customerid", length = 50)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long customerId;
	
	@Column(name = "registerDate", nullable= false)	
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	private LocalDate registerDate;
	
	@Column(name = "customername", length = 50, nullable= false)	
	private String customerName;
	
	@Column(name = "mobile", length = 10, unique=true,nullable= false)
	private String customerMobile;
	
	@Column(name = "password", length = 50, nullable= false)
	private String password;

	public RegistrationEntity() {
		super();
	}

	public RegistrationEntity(Long customerId, LocalDate registerDate, String customerName, String customerMobile,
			String password) {
		super();
		this.customerId = customerId;
		this.registerDate = registerDate;
		this.customerName = customerName;
		this.customerMobile = customerMobile;
		this.password = password;
	}

	/**
	 * @return the customerId
	 */
	public Long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the registerDate
	 */
	public LocalDate getRegisterDate() {
		return registerDate;
	}

	/**
	 * @param registerDate the registerDate to set
	 */
	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the customerMobile
	 */
	public String getCustomerMobile() {
		return customerMobile;
	}

	/**
	 * @param customerMobile the customerMobile to set
	 */
	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "RegistrationEntity [customerId=" + customerId + ", registerDate=" + registerDate + ", customerName="
				+ customerName + ", customerMobile=" + customerMobile + ", password=" + password + "]";
	}
	
	
	

	
	

}
