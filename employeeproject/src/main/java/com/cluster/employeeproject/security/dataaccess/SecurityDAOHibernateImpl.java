package com.cluster.employeeproject.security.dataaccess;

import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.cluster.employeeproject.common.dataaccess.BaseDAOHibernateImpl;
import com.cluster.employeeproject.entity.Security;


@Component
public class SecurityDAOHibernateImpl  extends BaseDAOHibernateImpl implements SecurityDAO
{	
	public List<Security> getAllSecurity()
	{
		/*List<Security> securities=null;
		Session session=sessionFactory.openSession();
	//	Transaction transaction=session.beginTransaction();
		
		Query query=session.createQuery("from Security");
		
		 securities=query.list();
	//	transaction.commit();
		session.close();*/
		System.out.println("hibernatetemplate "+getHibernateTemplate());
		
		return getHibernateTemplate().find(" from Security");
//		return securities;
	}
	
	

	@Override
	public Class getObjectType() 
	{
		return Security.class;
	}

}
