package com.cluster.employeeproject.commom.staticentity.dataaccess;

import org.springframework.stereotype.Repository;

import com.cluster.employeeproject.common.dataaccess.BaseDAOHibernateImpl;
import com.cluster.employeeproject.entity.Role;

@Repository
public class RoleDAOHibernateImpl extends BaseDAOHibernateImpl implements
		RoleDAO {

	@Override
	public Class getObjectType()
	{
		return Role.class;
	}

}
