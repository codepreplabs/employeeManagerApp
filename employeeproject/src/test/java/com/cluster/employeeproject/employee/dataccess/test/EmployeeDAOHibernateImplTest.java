package com.cluster.employeeproject.employee.dataccess.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



import com.cluster.employeeproject.employee.dataccess.EmployeeDAO;
import com.cluster.employeeproject.entity.AddressType;
import com.cluster.employeeproject.entity.City;
import com.cluster.employeeproject.entity.Country;
import com.cluster.employeeproject.entity.Department;
import com.cluster.employeeproject.entity.Employee;
import com.cluster.employeeproject.entity.EmployeeAddress;
import com.cluster.employeeproject.entity.Login;
import com.cluster.employeeproject.entity.State;

public class EmployeeDAOHibernateImplTest 
{
	
	EmployeeDAO employeeDAO;

	@Before
	public void setUp() throws Exception 
	{
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		employeeDAO=(EmployeeDAO) applicationContext.getBean("employeeDAOHibernateImpl");
		
	}

	@After
	public void tearDown() throws Exception 
	{
		employeeDAO =null;
	}

	@Test
	public void testFindALLActiveEmployee() 
	{
		List<Employee> employees=employeeDAO.findALLActiveEmployee();
		employees.iterator().next().getFirstName();
		System.out.println(employees.iterator().next().getFirstName());
//		assertEquals("AMIT",employees.iterator().next().getFirstName());
	}

	@Test
	public void testFindEmployee() 
	{
		Employee employee=employeeDAO.findEmployee("vikram","vikram@gmail.com");
		System.out.println(employee.getEmployeeId());
	}

	@Test
	public void testFindImageByEmployeeId() 
	{
		try
		{
			FileOutputStream fileOutputStream=new FileOutputStream("C:/Users/Admin/Desktop/testproject/output.jpg");
			byte[] bfile=employeeDAO.findImageByEmployeeId(12);
			
						
			fileOutputStream.write(bfile);
			fileOutputStream.close();
			
			assertNotNull(bfile);
			
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSave()
		{Department department=new Department();
		department.setDepartmentId(10);
		
		Employee employee=new Employee();
		employee.setFirstName("Vikram");
		employee.setLastName("Lonkar");
		employee.setEmailId("vikram@gmail.com");
		
		EmployeeAddress employeeAddress = new EmployeeAddress();
		employeeAddress.setAddressline1("Golden Street");
		employeeAddress.setAddressline2("Pune");
		employeeAddress.setZipcode(5666065);
		employeeAddress.setEmployee(employee);
		AddressType addressType = new AddressType();
		addressType.setAddressTypeId(10);
	
		employeeAddress.setAddressType(addressType);
	
		Set<EmployeeAddress> hsEmployeeAddresses = new HashSet<EmployeeAddress>();
		hsEmployeeAddresses.add(employeeAddress);
	
		City city = new City();
		city.setCityId(10);
		city.setEmployeeAddresses(hsEmployeeAddresses);
		employeeAddress.setCity(city);
	
		State state = new State();
		state.setStateId(10);
	
		Set<State> hsStates = new HashSet<State>();
		hsStates.add(state);
	
		Set<City> hsCities = new HashSet<City>();
		hsCities.add(city);
	
		state.setCities(hsCities);
		city.setState(state);
	
		Country country = new Country();
		country.setCountryId(10);
		country.setStates(hsStates);
	
		state.setCountry(country);
	
		employee.setEmployeeAddresses(hsEmployeeAddresses);
		employeeAddress.setEmployee(employee);
	
		
		
		
		Set<EmployeeAddress> hsAddresses=new HashSet<EmployeeAddress>();
		hsAddresses.add(employeeAddress);
		
		
		
		
		
		Set<Employee> hsEmployees=new HashSet<Employee>();
		hsEmployees.add(employee);		
		employee.setDepartment(department);
		department.setEmployees(hsEmployees);
		
		employeeAddress.setEmployee(employee);
		employee.setEmployeeAddresses(hsAddresses);
	
		//save image to file
	//	File file=new File("D:/Public/Snap/school.jpg");
		File file=new File("D:/Public/Snap/html.png");
		byte[] bFile=new byte[(int)file.length()];
		
		
		try {
			FileInputStream fileInputStream=new FileInputStream(file);
			fileInputStream.read(bFile);
			fileInputStream.close();
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		System.out.println("filesize"+file.length());
		System.out.println("bfile"+bFile.length);
		
		employee.setImage(bFile);
		
		Login login=new Login();
		login.setUsername("vikram");
		login.setPassword("vikram");
		login.setEmployee(employee);
		
		Set<Login> logins=new HashSet<Login>();
		logins.add(login);
		
		employee.setLogins(logins);
		
		assertNotNull(employeeDAO.save(employee));
		
			
	}

	@Test
	public void testFindByPrimaryKey()
	{
		Employee employee=(Employee) employeeDAO.findByPrimaryKey(12);
		System.out.println(employee.getFirstName());
		
	}

	@Test
	public void testUpdate() 
	{
		Employee employee=(Employee) employeeDAO.findByPrimaryKey(12);
		System.out.println(employee.getEmployeeId());
		employee.setFirstName("Rohit");
		employeeDAO.update(employee);
	}

	@Test
	public void testDelete() 
	{
		
		fail("Not yet implemented");
	}
	
	@Test
	public void testFindAll()
	{
		
		for (Object object :employeeDAO.findAll() )
		{
			Employee employee=(Employee)object;
			System.out.println(employee.getEmployeeId());
			
		}
		
	}

	
	
}
