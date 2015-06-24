package com.cluster.employeeproject.common.dataaccess.test;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cluster.employeeproject.common.dataaccess.BaseDAOHibernateImpl;
import com.cluster.employeeproject.entity.AddressType;
import com.cluster.employeeproject.entity.City;
import com.cluster.employeeproject.entity.Country;
import com.cluster.employeeproject.entity.Department;
import com.cluster.employeeproject.entity.Employee;
import com.cluster.employeeproject.entity.EmployeeAddress;
import com.cluster.employeeproject.entity.EmployeePhone;
import com.cluster.employeeproject.entity.State;


public class BaseDAOHibernateImplTest 
{
	
	BaseDAOHibernateImpl baseDAOHibernateImpl;
	

	@Before
	public void setUp() throws Exception 
	{
	}

	@After
	public void tearDown() throws Exception
	{
		baseDAOHibernateImpl=null;
	}

	@Test
	public void testSave() 
	{
		
		/*Department department=new Department();
		department.setDepartmentId(10);
		
		Employee employee=new Employee();
		employee.setFirstName("R");
		employee.setLastName("B");
		
		EmployeeAddress employeeAddress = new EmployeeAddress();
		employeeAddress.setAddressline1("6thblock");
		employeeAddress.setAddressline2("Rajajinagar");
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
//		File file=new File("D:/Public/Snap/school.jpg");
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
		
		assertNotNull(baseDAOHibernateImpl.save(employee));*/
		
		
		
		
	}

	@Test
	public void testFindByPrimaryKey() 
	{
	}

	@Test
	public void testUpdate()
	{
	}

	@Test
	public void testDelete()
	{
		
	}

	@Test
	public void testFindAll()
	{
		
		for (Object object :baseDAOHibernateImpl.findAll() )
		{
			Employee employee=(Employee)object;
			System.out.println(employee.getEmployeeId());
			
		}
		
	}

}
