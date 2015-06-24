package com.cluster.employeeproject.employee.businessservice.test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cluster.employeeproject.employee.businessservice.EmployeeBS;
import com.cluster.employeeproject.employee.businessservice.EmployeeService;
import com.cluster.employeeproject.entity.Employee;
import com.cluster.employeeproject.entity.Login;
import com.cluster.employeeproject.login.dataaccess.LoginDAO;
import com.cluster.employeeproject.login.dataaccess.LoginDAOHibernateImpl;



public class EmployeeServiceTest
{
	EmployeeBS employeeBS;

	@Before
	public void setUp() throws Exception 
	{
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		employeeBS=(EmployeeService) applicationContext.getBean("employeeService");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSave()
	{
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		LoginDAO loginDAO=(LoginDAOHibernateImpl) applicationContext.getBean("loginDAOHibernateImpl");
		Login login=new Login();
		login.setUsername("vikram");
		login.setPassword("vikram");
		Employee employee=loginDAO.authenticateUser(login);
		System.out.println();
//		long roleId=employee.getEmployeeRoles().iterator().next().getRole().getRoleId();
		System.out.println("before save method");
		
		
		Employee employee2=new Employee();
		employee2.setFirstName("prashant");
		Login login2=new Login();
		login2.setUsername("prashant");
		login2.setPassword("prashant");
		login2.setEmployee(employee2);
		
		Set<Login> hsLogins=new HashSet<Login>();
		hsLogins.add(login2);
		
		employee2.setLogins(hsLogins);
		
		try 
		{
			
			assertNotSame("0", employeeBS.save(employee2,10 ));
			System.out.println("after save method  success");
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*Employee employee=new Employee();
		employee.setFirstName("RAVI");
		employee.setEmailId("ravi@gmail.com");
		Login login=new Login();
		login.setUsername("RAVI");
		login.setPassword("RAVI");
		login.setEmployee(employee);
		
		Set<Login> hsLogins=new HashSet<Login>();
		hsLogins.add(login);
		
		employee.setLogins(hsLogins);
		try {
			employeeBS.save(employee, 10);
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();*/
		}
	
		
	

	@Test
	public void testFindAll() 
	{
		List<Employee> employees = employeeBS.findAll();
		
		for (Employee employee : employees)
		{
			System.out.println(employee.getEmployeeId());
			
		}
		assertEquals("RAJ", employees.iterator().next().getFirstName());
	}

	@Test
	public void testFindAllActiveEmployee() 
	{
		List<Employee> list=employeeBS.findAllActiveEmployee();
		
		for (Employee employee : list)
		{
			System.out.println(employee.getEmployeeId()+" "+employee.getFirstName()+" "+employee.getStatus().getStatusId());
			
		}
	}

	@Test
	public void testFindEmployeeById() 
	{
		Employee employee=employeeBS.findEmployeeById(3);
		System.out.println(employee.getFirstName());
		assertEquals("AJAY",employee.getFirstName());
	}

	@Test
	public void testDelete() 
	{
	}

	@Test
	public void testUpdate()
	{
		Employee employee=employeeBS.findEmployeeById(10);
		employee.setFirstName("VIKRAM");
		employeeBS.update(employee);
	}

	@Test
	public void testFindImageByEmployeedId()
	{
	}

}
