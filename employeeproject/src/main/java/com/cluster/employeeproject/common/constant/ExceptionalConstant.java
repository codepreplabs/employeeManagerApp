package com.cluster.employeeproject.common.constant;

public enum ExceptionalConstant 
{
	USER_EXIST("user.exist"),
	WRONG_USER_CREDNTIALS("wrong.user.credentials"),
	ACCOUNT_LOCKED("account.locked"),
	INVALID_USER("invalid.user"),
	EMAIL_EXIST("email.exist");
	
	String constantValue;
	
	private ExceptionalConstant(String value) 
	{
		this.constantValue=value;
	}

	public String getConstantValue() {
		return constantValue;
	}

	public void setConstantValue(String constantValue) {
		this.constantValue = constantValue;
	}
	
	

}
