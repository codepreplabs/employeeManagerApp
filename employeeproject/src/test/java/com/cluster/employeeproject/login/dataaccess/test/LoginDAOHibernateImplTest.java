package com.cluster.employeeproject.login.dataaccess.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cluster.employeeproject.entity.Employee;
import com.cluster.employeeproject.entity.Login;
import com.cluster.employeeproject.login.dataaccess.LoginDAO;

public class LoginDAOHibernateImplTest
{
	LoginDAO loginDAO;

	@Before
	public void setUp() throws Exception
	{
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		loginDAO=(LoginDAO) applicationContext.getBean("loginDAOHibernateImpl");
	}

	@After
	public void tearDown() throws Exception 
	{
		loginDAO=null;
	}

	@Test
	public void testAuthenticateUser() 
	{
		Login login=new Login();
		login.setUsername("RAVI");
		login.setPassword("RAVI");
		
		Employee employee=loginDAO.authenticateUser(login);
		System.out.println(employee.getEmailId());
	}

}
