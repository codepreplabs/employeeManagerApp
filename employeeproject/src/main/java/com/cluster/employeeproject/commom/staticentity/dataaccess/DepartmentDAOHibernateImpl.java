package com.cluster.employeeproject.commom.staticentity.dataaccess;

import org.springframework.stereotype.Repository;

import com.cluster.employeeproject.common.dataaccess.BaseDAOHibernateImpl;
import com.cluster.employeeproject.entity.Department;

@Repository
public class DepartmentDAOHibernateImpl extends BaseDAOHibernateImpl implements
		DepartmentDAO {

	@Override
	public Class getObjectType() 
	{
		return Department.class;
	}

}
