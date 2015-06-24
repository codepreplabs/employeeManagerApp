package com.cluster.employeeproject.employee.businessservice;

import java.io.InputStream;
import java.util.List;

import com.cluster.employeeproject.entity.Employee;


public interface EmployeeBS 
{
	Employee save(Employee pEmployee,long pRole) throws ClassNotFoundException,IllegalArgumentException,Exception;
	List<Employee> findAll();
	List<Employee> findAllActiveEmployee();
	Employee  findEmployeeById(long pEmployeeId);
	void delete(List<Long> pEmployeeIds,long pRole) throws ClassNotFoundException,IllegalArgumentException,Exception;;
	void update(Employee pEmployee);
	byte[] findImageByEmployeedId(long pEmployeeId);
}
