package com.cluster.employeeproject.commom.staticentity.dataaccess;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cluster.employeeproject.common.dataaccess.BaseDAOHibernateImpl;
import com.cluster.employeeproject.entity.City;

@Repository
public class CityDAOHibernateImpl extends BaseDAOHibernateImpl implements
		CityDAO {

	@Override
	public Class getObjectType() 
	{
		return City.class;
	}

}
