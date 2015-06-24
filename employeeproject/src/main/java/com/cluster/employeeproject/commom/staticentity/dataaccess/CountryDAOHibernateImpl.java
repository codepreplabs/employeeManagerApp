package com.cluster.employeeproject.commom.staticentity.dataaccess;

import org.springframework.stereotype.Repository;

import com.cluster.employeeproject.common.dataaccess.BaseDAOHibernateImpl;
import com.cluster.employeeproject.entity.Country;

@Repository
public class CountryDAOHibernateImpl extends BaseDAOHibernateImpl implements
		CountryDAO {

	@Override
	public Class getObjectType()
	{
		return Country.class;
	}

}
