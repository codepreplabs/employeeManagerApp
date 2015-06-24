package com.cluster.employeeproject.common.exception;

public class EmployeeManagementApplicationException extends Exception
{
	private  Integer errorCode;
	private String errorKey;
	private String errorMessage;
	
	public EmployeeManagementApplicationException(String message) 
	{
		super(message);
	}
	
	public EmployeeManagementApplicationException()
	{
		
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorKey() {
		return errorKey;
	}

	public void setErrorKey(String errorKey) {
		this.errorKey = errorKey;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
	

}
