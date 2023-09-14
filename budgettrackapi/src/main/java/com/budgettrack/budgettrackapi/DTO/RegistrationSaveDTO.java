package com.budgettrack.budgettrackapi.DTO;

import jakarta.persistence.Column;

public class RegistrationSaveDTO {

	
	private String customerName;
	
	private String customerMobile;
	
	private String password;
	

	
	public RegistrationSaveDTO() {
	}



	public RegistrationSaveDTO(String customerName, String customerMobile, String password) {
		super();
		this.customerName = customerName;
		this.customerMobile = customerMobile;
		this.password = password;
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
		return "RegistrationSaveDTO [customerName=" + customerName
				+ ", customerMobile=" + customerMobile + ", password=" + password + "]";
	}


	
	
	
}
