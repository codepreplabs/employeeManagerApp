package com.cluster.employeeproject.common.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cluster.employeeproject.common.exception.EmployeeManagementSecurityException;
import com.cluster.employeeproject.entity.Security;
import com.cluster.employeeproject.security.dataaccess.SecurityDAO;
import com.cluster.employeeproject.security.dataaccess.SecurityDAOHibernateImpl;


@Component
public class ApplicationSecurity 
{
	@Autowired
	SecurityDAO securityDAO;
	
	public  boolean hasPermission(String appName,long roleId) throws ClassNotFoundException,InstantiationException,IllegalAccessException, EmployeeManagementSecurityException
	{
		boolean isvalid=false;
 //	EmployeeManagementSecurityException employeeManagementSecurityException=new EmployeeManagementSecurityException();
		
//		SecurityDAO securityDAO=new SecurityDAOHibernateImpl();
//		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
//		SecurityDAO securityDAO=(SecurityDAO) applicationContext.getBean("securityDAOHibernateImpl");
		List<Security> allSecurity=securityDAO.getAllSecurity();
		System.out.println(allSecurity);
		
		System.out.println("Inside Application Security haspersmissiom");
		for (Security security : allSecurity) 
		{
			if(security.getRole().getRoleId()==roleId && security.getApplication().equalsIgnoreCase(appName))
			{
				isvalid=true;
				break;
			}
			
		}
		
		if(!isvalid)
		{
			throw new EmployeeManagementSecurityException();
		}
		
		return true;
		
	}

}
