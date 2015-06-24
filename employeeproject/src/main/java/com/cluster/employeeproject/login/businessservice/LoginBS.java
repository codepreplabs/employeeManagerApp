package com.cluster.employeeproject.login.businessservice;

import com.cluster.employeeproject.common.exception.EmployeeManagementApplicationException;
import com.cluster.employeeproject.entity.Employee;
import com.cluster.employeeproject.entity.Login;



public interface LoginBS 
{
	public Employee authenticateUser(Login pLogin) throws EmployeeManagementApplicationException;

}
