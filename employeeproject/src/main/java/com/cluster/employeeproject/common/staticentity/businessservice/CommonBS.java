package com.cluster.employeeproject.common.staticentity.businessservice;

import java.util.List;

import com.cluster.employeeproject.entity.City;
import com.cluster.employeeproject.entity.Country;
import com.cluster.employeeproject.entity.Department;
import com.cluster.employeeproject.entity.Role;
import com.cluster.employeeproject.entity.State;



public interface CommonBS
{
	List<Department> getAllDepartments();
	List<Role> getAllRoles();
	List<City> getAllCities();
	List<State> getAllStates();
	List<Country>getAllCountries();

}
