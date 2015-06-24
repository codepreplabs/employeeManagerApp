package com.cluster.employeeproject.commom.staticentity.dataaccess;

import org.springframework.stereotype.Repository;

import com.cluster.employeeproject.common.dataaccess.BaseDAOHibernateImpl;
import com.cluster.employeeproject.entity.State;

@Repository
public class StateDAOHibernateImpl extends BaseDAOHibernateImpl implements
		StateDAO {

	@Override
	public Class getObjectType() 
	{
		return State.class;
	}

}
