package com.cluster.employeeproject.security.dataaccess;

import java.util.List;

import com.cluster.employeeproject.common.dataaccess.BaseDAO;
import com.cluster.employeeproject.entity.Security;


public interface SecurityDAO extends BaseDAO 
{
	public List<Security> getAllSecurity();
	

}
