package com.cluster.employeeproject.login.dataaccess;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.cluster.employeeproject.common.dataaccess.BaseDAOHibernateImpl;
import com.cluster.employeeproject.entity.Employee;
import com.cluster.employeeproject.entity.Login;


@Component
public class LoginDAOHibernateImpl extends BaseDAOHibernateImpl implements LoginDAO
{

	/*public Employee authenticateUser(Login login) 
	{
		Employee employee=null;
//		Session session= sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
//		transaction.begin();
 		Query query=session.createQuery("Select employee FROM Employee as employee JOIN  employee.logins as login WHERE login.username=:name");
	     query.setParameter("name",login.getUsername());
	     employee=(Employee) query.setMaxResults(1).uniqueResult();
//	     transaction.commit();
//	     session.close();    
	     
		return employee;
	}*/

	
	@Override
	public Class getObjectType() {
		return Login.class;
	}

	@Override
	public Employee authenticateUser(Login login) 
	{
		
		String strHQL="Select employee FROM Employee as employee JOIN  employee.logins as login WHERE login.username =?";
		return (Employee) getHibernateTemplate().find(strHQL,login.getUsername()).iterator().next();
		
	}

	

}
