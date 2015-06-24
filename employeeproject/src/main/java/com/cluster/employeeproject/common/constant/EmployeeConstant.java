package com.cluster.employeeproject.common.constant;

public enum EmployeeConstant 
{
	
	
	STATUS_ACTIVE(10),STATUS_INACTIVE(20),PERMANENT(10),TEMPORARY(20),PHONE_TYPE_MOBILE(10),
	PHONE_TYPE_HOME(20),PHONE_TYPE_OFFICE(30),ROLE_ADMIN(10),ROLE_EMPLOYEE(20);
	
	int constantValue;

	
	private EmployeeConstant(int con) 
	{
		this.constantValue=con;
		
	}
	
	
	
	public int getConstantValue() {
		return constantValue;
	}

	public void setConstantValue(int constantValue) {
		this.constantValue = constantValue;
	}
	
	

}
