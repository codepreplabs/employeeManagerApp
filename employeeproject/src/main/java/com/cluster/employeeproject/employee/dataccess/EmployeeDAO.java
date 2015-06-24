package com.cluster.employeeproject.employee.dataccess;

import java.util.List;

import com.cluster.employeeproject.common.dataaccess.BaseDAO;
import com.cluster.employeeproject.entity.Employee;

public interface EmployeeDAO extends BaseDAO
{
	List<Employee> findALLActiveEmployee();

	public Employee findEmployee(String pUserNAme,String pEmailId);
	
	byte[] findImageByEmployeeId(long pEmployeeId);

}
