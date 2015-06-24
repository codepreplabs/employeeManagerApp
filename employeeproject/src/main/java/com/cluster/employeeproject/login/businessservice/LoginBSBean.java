package com.cluster.employeeproject.login.businessservice;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cluster.employeeproject.common.constant.EmployeeConstant;
import com.cluster.employeeproject.common.constant.ExceptionalConstant;
import com.cluster.employeeproject.common.exception.EmployeeManagementApplicationException;
import com.cluster.employeeproject.employee.businessservice.EmployeeService;
import com.cluster.employeeproject.employee.dataccess.EmployeeDAO;
import com.cluster.employeeproject.employee.dataccess.EmployeeDAOHibernateImpl;
import com.cluster.employeeproject.entity.Employee;
import com.cluster.employeeproject.entity.Login;
import com.cluster.employeeproject.login.dataaccess.LoginDAO;



@Component
@Scope(value="prototype")
public class LoginBSBean implements LoginBS 
{
	@Autowired
	LoginDAO loginDAO;
	
	@Autowired
	EmployeeDAO employeeDAO;
	
	
	public LoginDAO getLoginDAO() {
		return loginDAO;
	}

	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

	public LoginBSBean() 
	{
//		loginDAO=(LoginDAO)DAOFactory.getDao(LoginDAO.class);
		
	}

	public Employee authenticateUser(Login pLogin)
			throws EmployeeManagementApplicationException
	{
//		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
//		EmployeeDAO employeeDAO=(EmployeeDAOHibernateImpl) applicationContext.getBean("employeeDAOHibernateImpl");
		String dbPassword=null;		
		Date lastAccessDate;
		Date presentDate;
		long perviousLoginAttempts;
		long timeDifference;
		long daysDiffernece;
		Employee employee=null;
		EmployeeManagementApplicationException applicationException=new EmployeeManagementApplicationException();
		
		try
		{
			System.out.println("loginDao "+loginDAO);
			System.out.println("employeeDao "+employeeDAO);
//			EmployeeDAO employeeDAO=(EmployeeDAO)DAOFactory.getDao(EmployeeDAO.class);
			employee=loginDAO.authenticateUser(pLogin);
			
			System.out.println("11111111111111111");
			dbPassword=employee.getLogins().iterator().next().getPassword();
			perviousLoginAttempts=employee.getLogins().iterator().next().getTotalLoginAttempts();
			lastAccessDate=employee.getLogins().iterator().next().getDateLastLogin();
			
			presentDate=new Date();
			
			timeDifference=presentDate.getTime()-lastAccessDate.getTime();
			daysDiffernece=(timeDifference)/(1000*60*60*24);
			
			System.out.println("dbpassword"+dbPassword);
			System.out.println(pLogin.getPassword());
			if(!pLogin.getPassword().equalsIgnoreCase(dbPassword))
			{
				System.out.println("checking password");
				if(perviousLoginAttempts < 3)
				{
					System.out.println(perviousLoginAttempts);
					employee.getLogins().iterator().next().setTotalLoginAttempts(perviousLoginAttempts+1);
					employeeDAO.update(employee);
					System.out.println("update");
					applicationException.setErrorKey(ExceptionalConstant.WRONG_USER_CREDNTIALS.getConstantValue());
					throw applicationException;
				}
				else
				{
					employee.getStatus().setStatusId(EmployeeConstant.STATUS_INACTIVE.getConstantValue());
					employeeDAO.update(employee);
					
					applicationException.setErrorKey(ExceptionalConstant.ACCOUNT_LOCKED.getConstantValue());
					throw applicationException;	
					
				}
				
			}
			else if (daysDiffernece > 90)
			{
				System.out.println("day >90" +daysDiffernece);
				
				employee.getStatus().setStatusId(EmployeeConstant.STATUS_INACTIVE.getConstantValue());
				employeeDAO.update(employee);
				System.out.println("update in day >90");
				applicationException.setErrorKey(ExceptionalConstant.ACCOUNT_LOCKED.getConstantValue());
				throw applicationException;
				
			}
			else if(employee.getStatus().getStatusId()==20)
			{
				System.out.println("Inactive");
				applicationException.setErrorKey(ExceptionalConstant.ACCOUNT_LOCKED.getConstantValue());
				throw applicationException;
			}
			System.out.println("welcome");
			
			employee.getLogins().iterator().next().setTotalLoginAttempts(0);
			employee.getLogins().iterator().next().setDateLastLogin(new Date(System.currentTimeMillis()));
			employeeDAO.update(employee);
			System.out.println("success");
		}
		catch (NullPointerException e)
		{
			System.out.println("Invalid User in loginBSBean");
			applicationException.setErrorKey(ExceptionalConstant.INVALID_USER.getConstantValue());
			throw applicationException;
		}
		
		return employee;
		
	}

}
