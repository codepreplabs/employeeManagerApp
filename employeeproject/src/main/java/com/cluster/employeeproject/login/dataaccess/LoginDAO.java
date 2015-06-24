package com.cluster.employeeproject.login.dataaccess;

import com.cluster.employeeproject.entity.Employee;
import com.cluster.employeeproject.entity.Login;




public interface LoginDAO 
{
	public Employee authenticateUser(Login login);

}
