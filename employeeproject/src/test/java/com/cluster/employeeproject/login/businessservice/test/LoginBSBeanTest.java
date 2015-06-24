package com.cluster.employeeproject.login.businessservice.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cluster.employeeproject.common.exception.EmployeeManagementApplicationException;
import com.cluster.employeeproject.entity.Employee;
import com.cluster.employeeproject.entity.Login;
import com.cluster.employeeproject.login.businessservice.LoginBS;



public class LoginBSBeanTest
{
	LoginBS loginBSBean;

	@Before
	public void setUp() throws Exception 
	{
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		loginBSBean=(LoginBS) applicationContext.getBean("loginBSBean");
		System.out.println(loginBSBean);
		
//		loginBSBean=new LoginBSBean() ;
	}

	@After
	public void tearDown() throws Exception 
	{
		loginBSBean=null;		
	}

	@Test
	public void testAuthenticateUser()  
	{
		Login login=new Login();
		login.setUsername("vikram");
		login.setPassword("vikram");
		
		Employee employee;
		try {
			employee = loginBSBean.authenticateUser(login);
			System.out.println(employee.getFirstName());
		} catch (EmployeeManagementApplicationException e) 
		{
			System.out.println(e.getErrorKey());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
