package com.budgettrack.budgettrackapi.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class RegistrationDTO {
	
	private Long customerId;
	
	private String customerName;
	
	private String customerMobile;
	
	private String password;
	
	public RegistrationDTO() {
	}


	/**
	 * @param customerId
	 * @param customerName
	 * @param customerMobile
	 * @param password
	 */
	public RegistrationDTO(Long customerId, String customerName, String customerMobile, String password) {
		this.customerId = customerId;
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
		return "RegistrationEntity [customerId=" + customerId + ", customerName=" + customerName + ", customerMobile="
				+ customerMobile + ", password=" + password + "]";
	}
	

}
