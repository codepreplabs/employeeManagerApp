package com.cluster.employeeproject.web.login.mapper;

import com.cluster.employeeproject.entity.Login;
import com.cluster.employeeproject.web.login.to.LoginTO;


public class LoginMapper 
{
	public static Login getEntityFromTO(LoginTO pLoginTO)
	{
		Login login=new Login();
		login.setUsername(pLoginTO.getUsername());
		login.setPassword(pLoginTO.getPassword());		
		return login;
	}

}
