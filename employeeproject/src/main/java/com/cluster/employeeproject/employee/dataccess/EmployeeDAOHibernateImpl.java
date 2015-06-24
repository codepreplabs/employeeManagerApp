package com.cluster.employeeproject.employee.dataccess;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cluster.employeeproject.common.constant.EmployeeConstant;
import com.cluster.employeeproject.common.dataaccess.BaseDAOHibernateImpl;
import com.cluster.employeeproject.entity.Employee;


public class EmployeeDAOHibernateImpl extends BaseDAOHibernateImpl implements
		EmployeeDAO {

	@Override
	public List<Employee> findALLActiveEmployee() 
	{
		long statusId=EmployeeConstant.STATUS_ACTIVE.getConstantValue();
		return getHibernateTemplate().find("FROM "+getObjectType().getSimpleName()+" WHERE status ="+statusId);
		
	}

	@Override
	public Employee findEmployee(String pUserName, String pEmailId)
	{
		String hqlQuery="SELECT employee FROM Employee employee JOIN employee.logins as login WHERE login.username=:username OR employee.emailId=:email ";
		String paramNames[]={"username","email"};
		String values[]={pUserName,pEmailId};
		System.out.println(" findEmployee");
      /*List<Employee> employee= getHibernateTemplate().find("SELECT employee FROM Employee employee JOIN employee.logins as login WHERE login.username ='"+pUserName +
				"' OR employee.emailId='"+pEmailId+"'");*/
		
		List<Employee> employee=getHibernateTemplate().findByNamedParam(hqlQuery, paramNames, values);
      
     if( employee.size()==0)
     {
    	 return null;
     }
     
      
//      Employee employee=(Employee) getHibernateTemplate().find("SELECT employee FROM Employee employee JOIN employee.logins as login WHERE login.username ='"+pUserName +
//				"' OR employee.emailId='"+pEmailId+"'").iterator().next();
      return employee.iterator().next();
	}

	@Override
	public byte[] findImageByEmployeeId(long pEmployeeId)
	{
	 
		Iterator itr=getHibernateTemplate().find("SELECT image FROM "+getObjectType().getSimpleName()+" WHERE employeeId =?",pEmployeeId).iterator();
		return (byte[]) itr.next();
		
	}

	@Override
	public Class getObjectType()
	{
		return Employee.class;
	}

}
