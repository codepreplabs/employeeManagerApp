package com.cluster.employeeproject.security.dataaccess.text;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cluster.employeeproject.employee.businessservice.EmployeeService;
import com.cluster.employeeproject.entity.Security;
import com.cluster.employeeproject.security.dataaccess.SecurityDAO;
import com.cluster.employeeproject.security.dataaccess.SecurityDAOHibernateImpl;



public class SecurityDAOHibernateImplTest
{
	SecurityDAO securityDAO;

	@Before
	public void setUp() throws Exception 
	{
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		securityDAO=(SecurityDAOHibernateImpl) applicationContext.getBean("securityDAOHibernateImpl");
	}

	@After
	public void tearDown() throws Exception
	{
		securityDAO=null;
	}

	@Test
	public void testGetAllSecurity()
	{
		List<Security> securities=securityDAO.getAllSecurity();
		System.out.println(securities.iterator().next().getApplication());
		assertNotNull(securities.iterator().next().getApplication());
		
	}

}
