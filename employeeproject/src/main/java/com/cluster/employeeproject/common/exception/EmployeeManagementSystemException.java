package com.cluster.employeeproject.common.exception;

public class EmployeeManagementSystemException extends Exception 
{
	

	private Integer errorcode;

	private String errorkey;

	private String errorMessage;

	public EmployeeManagementSystemException(String message) 
	{
		super(message);
	}
	
	public EmployeeManagementSystemException() 
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
