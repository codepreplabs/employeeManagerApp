package com.cluster.employeeproject.web.login.to;

import com.cluster.employeeproject.web.employee.to.EmployeeTO;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginTO.
 */
public class LoginTO 
{
	
	/** The username. */
	private String username;
	
	/** The password. */
	private String password;
	
	/** The employee to. */
	private EmployeeTO employeeTO;

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() 
	{
		return username;
	}
	
	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) 
	{
		this.username = username;
	}
	
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword()
	{
		return password;
	}
	
	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	/**
	 * Gets the employee.
	 *
	 * @return the employee
	 */
	public EmployeeTO getEmployee() 
	{
		return employeeTO;
	}
	
	/**
	 * Sets the employee.
	 *
	 * @param employee the new employee
	 */
	public void setEmployee(EmployeeTO employee)
	{
		this.employeeTO = employee;
	}
	
}
