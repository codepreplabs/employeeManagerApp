package com.cluster.employeeproject.common.dataaccess;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.cluster.employeeproject.common.entity.BaseDO;

public abstract class BaseDAOHibernateImpl implements BaseDAO
{
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	
	public HibernateTemplate getHibernateTemplate()
	{
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate)
	{
		this.hibernateTemplate = hibernateTemplate;
	}

	public BaseDO save(BaseDO baseTO)
	{
		 hibernateTemplate.save(baseTO);
		return baseTO;
	}

	public BaseDO findByPrimaryKey(long id)
	{
		return (BaseDO) hibernateTemplate.get(getObjectType().getName(), id);
		
	}

	public void update(BaseDO baseDO) 
	{		
		hibernateTemplate.update(baseDO);
		
	}

	public void delete(BaseDO baseDO) 
	{
		hibernateTemplate.delete(baseDO);
		
	}

	public List findAll() 
	{
		System.out.println("from "+getObjectType().getName());
		return hibernateTemplate.find("FROM "+getObjectType().getName());
		
	}

	abstract public Class getObjectType();
	
}
