package com.budgettrack.budgettrackapi.DTO;

public class LoginDTO {
	
	private String customerMobile;
	
	private String password;

	public LoginDTO() {
		super();
	}

	public LoginDTO(String customerMobile, String password) {
		super();
		this.customerMobile = customerMobile;
		this.password = password;
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
		return "LoginDTO [customerMobile=" + customerMobile + ", password="
				+ password + "]";
	}
	
	
	
	

}
