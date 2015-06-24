package com.cluster.employeeproject.common.staticentity.businessservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cluster.employeeproject.commom.staticentity.dataaccess.CityDAO;
import com.cluster.employeeproject.commom.staticentity.dataaccess.CountryDAO;
import com.cluster.employeeproject.commom.staticentity.dataaccess.DepartmentDAO;
import com.cluster.employeeproject.commom.staticentity.dataaccess.RoleDAO;
import com.cluster.employeeproject.commom.staticentity.dataaccess.StateDAO;
import com.cluster.employeeproject.entity.City;
import com.cluster.employeeproject.entity.Country;
import com.cluster.employeeproject.entity.Department;
import com.cluster.employeeproject.entity.Role;
import com.cluster.employeeproject.entity.State;


@Service
public class CommonBSBean implements CommonBS
{
	@Autowired
	 DepartmentDAO departmentDAO;
	@Autowired
	 RoleDAO roleDAO;
	@Autowired
	 CountryDAO countryDAO;
//	@Autowired
	 CityDAO cityDAO;
	@Autowired
	 StateDAO stateDAO;
	
	
	DepartmentDAO getDepartmentDAO()
	{
		return departmentDAO ;
	}

	
	RoleDAO getRoleDAO()
	{
		return roleDAO;	
	}
	
	CityDAO getCityDAO()
	{
		return  cityDAO;		
	}
	
	StateDAO getStateDAO()
	{
		return  stateDAO;
	}
	
	CountryDAO  getCountryDAO()
	{
		return  countryDAO;
	}
	
	@Cacheable("departments")
	public List<Department> getAllDepartments()
	{
		System.out.println("getAllDepartments");
		return getDepartmentDAO().findAll();
	}

	public List<Role> getAllRoles() 
	{
		return getRoleDAO().findAll();
	}

	public List<City> getAllCities()
	{
		return getCityDAO().findAll();
	}

	public List<State> getAllStates()
	{
		return getStateDAO().findAll();
	}

	public List<Country> getAllCountries()
	{
		return getCountryDAO().findAll();
	}

}
