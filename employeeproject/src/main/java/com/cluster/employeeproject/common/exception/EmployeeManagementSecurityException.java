package com.cluster.employeeproject.common.exception;

public class EmployeeManagementSecurityException extends Exception 
{
	private Integer errorcode;

	private String errorkey;

	private String errorMessage;

	public EmployeeManagementSecurityException(String message) 
	{
		super(message);
	}
	
	public EmployeeManagementSecurityException() 
	{
		
	}

	public Integer getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(Integer errorcode) {
		this.errorcode = errorcode;
	}

	public String getErrorkey() {
		return errorkey;
	}

	public void setErrorkey(String errorkey) {
		this.errorkey = errorkey;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
	
	
	
	

}
