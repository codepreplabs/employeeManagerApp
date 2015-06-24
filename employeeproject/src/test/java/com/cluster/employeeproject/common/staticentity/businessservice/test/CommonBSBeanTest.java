package com.cluster.employeeproject.common.staticentity.businessservice.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cluster.employeeproject.common.staticentity.businessservice.CommonBS;
import com.cluster.employeeproject.employee.businessservice.EmployeeService;
import com.cluster.employeeproject.entity.Department;

public class CommonBSBeanTest 
{
	CommonBS commonBS;

	@Before
	public void setUp() throws Exception
	{
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		commonBS= (CommonBS) applicationContext.getBean("commonBSBean");
	}

	@After
	public void tearDown() throws Exception 
	{
		commonBS=null;
	}

	@Test
	public void testGetDepartmentDAO() 
	{
		List<Department> departments=commonBS.getAllDepartments();
		for (Department department : departments) 
		{
			System.out.println(department.getDepartmentName());
			
		}
		System.out.println("--------");
		List<Department> departments1=commonBS.getAllDepartments();
		for (Department department : departments1) 
		{
			System.out.println(department.getDepartmentName());
			
		}
		System.out.println();
	}

	@Test
	public void testGetRoleDAO() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCityDAO() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetStateDAO() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCountryDAO() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllDepartments() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllRoles() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllCities() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllStates() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllCountries() {
		fail("Not yet implemented");
	}

}
