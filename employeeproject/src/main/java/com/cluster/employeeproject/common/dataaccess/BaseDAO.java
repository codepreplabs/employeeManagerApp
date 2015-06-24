package com.cluster.employeeproject.common.dataaccess;

import java.util.List;

import com.cluster.employeeproject.common.entity.BaseDO;

public interface BaseDAO {
	
	public BaseDO save(final BaseDO baseTO);

	public BaseDO findByPrimaryKey(long id);

	public void update(final BaseDO baseTO);

	public void delete(final BaseDO baseTO);

	public List findAll();

}