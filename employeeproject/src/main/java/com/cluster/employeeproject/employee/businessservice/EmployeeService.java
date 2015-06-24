package com.cluster.employeeproject.employee.businessservice;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cluster.employeeproject.common.constant.ExceptionalConstant;
import com.cluster.employeeproject.common.exception.EmployeeManagementApplicationException;
import com.cluster.employeeproject.common.exception.EmployeeManagementSecurityException;
import com.cluster.employeeproject.common.security.ApplicationSecurity;
import com.cluster.employeeproject.employee.dataccess.EmployeeDAO;
import com.cluster.employeeproject.entity.Employee;


//@Component
@Service(value="employeeService")
public class EmployeeService implements EmployeeBS
{
	@Autowired
	EmployeeDAO employeeDAO;
	
	@Autowired
	ApplicationSecurity applicationSecurity;
	public EmployeeService() 
	{
		/*System.out.println("Inside EmployeeService constructor");
		employeeDAO=(EmployeeDAO)DAOFactory.getDao(EmployeeDAO.class);*/
	}

	public Employee save(Employee pEmployee, long pRole)
			throws Exception
	{
		String userName=pEmployee.getLogins().iterator().next().getUsername();
		String mailId=pEmployee.getEmailId();
		
		
		
		EmployeeManagementApplicationException employeeManagementApplicationException= new EmployeeManagementApplicationException();
		
		Employee employee=null;
		System.out.println(" --Security App:  " +this.getClass().getSimpleName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName());
		if(applicationSecurity.hasPermission(this.getClass().getSimpleName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName(), pRole))
		{
			System.out.println("Security App:  " +this.getClass().getSimpleName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName());
			
			employee=employeeDAO.findEmployee(userName, mailId);
			
			System.out.println("mailID : "+mailId);
			
			if(employee!=null)
			{
				System.out.println("dbemail : "+employee.getEmailId());
				
				if(employee.getLogins().iterator().next().getUsername().equalsIgnoreCase(userName))
				{
					System.out.println("Inside the service Exception ");
					
					employeeManagementApplicationException.setErrorKey(ExceptionalConstant.USER_EXIST.getConstantValue());
					throw employeeManagementApplicationException;
					
				}
				if(employee.getEmailId().equalsIgnoreCase(mailId))
				{
					System.out.println("Inside service exception due same emailId");
					employeeManagementApplicationException.setErrorKey(ExceptionalConstant.EMAIL_EXIST.getConstantValue());
					throw employeeManagementApplicationException;
				}
								
				
			 }				
			
			
			employee = (Employee) employeeDAO.save(pEmployee);
			System.out.println("after employee.save()");
			
			
			
			
			
		}
		
		
		return employee;
	}

	public List<Employee> findAll()
	{
		
		return employeeDAO.findAll();
	}

	public List<Employee> findAllActiveEmployee()
	{		
		return employeeDAO.findALLActiveEmployee();
	}

	public Employee findEmployeeById(long pEmployeeId) 
	{
		return (Employee) employeeDAO.findByPrimaryKey(pEmployeeId);
	}

	public void delete(List<Long> pEmployeeIds,long pRole) throws ClassNotFoundException, InstantiationException, IllegalAccessException, EmployeeManagementSecurityException
	{
		if(applicationSecurity.hasPermission(this.getClass().getSimpleName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName(), pRole))
		{
			for (long l:pEmployeeIds) 
			{				
				/*System.out.println("id"+l);
				Employee employee=findEmployeeById(l);
				
				System.out.println("employee"+employee);
				Status status=new Status();
				
				status.setStatusId(EmployeeConstant.STATUS_ACTIVE.getConstantValue());
				
				System.out.println("status"+status);
				Set<Employee> hsEmployees=new HashSet<Employee>();
				hsEmployees.add(employee);
				
				System.out.println("hsemployee"+hsEmployees);
				status.setEmployees(hsEmployees);
				employee.setStatus(status);
				
				employeeDAO.update(employee);*/
				System.out.println("employeeId to be delete "+l);
				employeeDAO.delete(findEmployeeById(l));
			}
						
		}
		
	}

	public void update(Employee pEmployee)
	{
		employeeDAO.update(pEmployee);
		
	}

	public byte[] findImageByEmployeedId(long pEmployeeId)
	{
		
		return employeeDAO.findImageByEmployeeId(pEmployeeId);
	}

	

}
