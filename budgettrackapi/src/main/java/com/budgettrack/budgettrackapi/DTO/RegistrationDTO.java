package com.budgettrack.budgettrackapi.DTO;


public class RegistrationDTO {
	
	private Long id;
	
	private String registerDate;
	
	private String customerName;
	
	private String customerMobile;
	
	private String password;


	/**
	 * 
	 */
	public RegistrationDTO() {
		super();
	}


	public RegistrationDTO(Long id, String registerDate, String customerName, String customerMobile, String password) {
		super();
		this.id = id;
		this.registerDate = registerDate;
		this.customerName = customerName;
		this.customerMobile = customerMobile;
		this.password = password;
	}


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the registerDate
	 */
	public String getRegisterDate() {
		return registerDate;
	}


	/**
	 * @param registerDate the registerDate to set
	 */
	public void setRegisterDate(String registerDate) {
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
		return "RegistrationDTO [id=" + id + ", registerDate=" + registerDate + ", customerName=" + customerName
				+ ", customerMobile=" + customerMobile + ", password=" + password + "]";
	}

	




}
