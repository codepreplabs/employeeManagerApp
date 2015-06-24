package com.cluster.employeeproject.login.managedbean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.cluster.employeeproject.common.exception.CommonUtil;
import com.cluster.employeeproject.common.exception.EmployeeManagementApplicationException;

import com.cluster.employeeproject.web.employee.mapper.EmployeeMapper;
import com.cluster.employeeproject.web.employee.to.EmployeeTO;
import com.cluster.employeeproject.web.login.mapper.LoginMapper;
import com.cluster.employeeproject.web.login.to.LoginTO;
import com.cluster.employeeproject.employee.businessservice.EmployeeBS;
import com.cluster.employeeproject.entity.Employee;
import com.cluster.employeeproject.entity.Login;
import com.cluster.employeeproject.login.businessservice.LoginBS;

//@ManagedBean
@Component
@Scope("session")
public class LoginBean 
{
	
	private LoginTO loginTO;
	
	private boolean admin=false;
	
	private List<EmployeeTO> listEmployees;
	
	@Autowired
	LoginBS loginBS;
	
	@Autowired
	EmployeeBS employeeBS   ;
	
	
	
	public LoginBS getLoginBS() {
		return loginBS;
	}


	public void setLoginBS(LoginBS loginBS) {
		this.loginBS = loginBS;
	}


	public EmployeeBS getEmployeeBS() {
		return employeeBS;
	}


	public void setEmployeeBS(EmployeeBS employeeBS) {
		this.employeeBS = employeeBS;
	}


	@PostConstruct
	public void init()
	{
		System.out.println(" postconstruct LogicBean ");
		loginTO=new LoginTO();
		
	}
	
	
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) 
	{
		this.admin = admin;
	}
	public List<EmployeeTO> getListEmployees() 
	{
		return listEmployees;
	}
	public void setListEmployees(List<EmployeeTO> listEmployees)
	{
		this.listEmployees = listEmployees;
	}

	
	public LoginTO getLoginTO() {
		return loginTO;
	}
	public void setLoginTO(LoginTO loginTO) {
		this.loginTO = loginTO;
	}
	public String checkUser()
	{
		String strReturn=null;
		Employee employee=null;
		
		Login login=LoginMapper.getEntityFromTO(loginTO);
		
//		LoginDelegate loginDelegate=new LoginDelegate();
	
		try 
		{
			System.out.println("loginBS "+loginBS);
			 employee=loginBS.authenticateUser(login);
			 
			 System.out.println("employee "+employee);
			 loginTO.setEmployee(EmployeeMapper.getTOFromEntity(employee));			 
			 
			 System.out.println("--");
			 System.out.println("role "+employee.getEmployeeRoles().iterator().next().getRole().getRoleId());
			if( employee.getEmployeeRoles().iterator().next().getEmployeeRoleId()==10)
			{
				admin=true;
				
			}
//			 admin=true;
			
			System.out.println("employee "+employee );
			strReturn="loginsuccess";
		} catch (EmployeeManagementApplicationException e) 
		{
			strReturn=null;
			CommonUtil.errorSet(e);
//			e.printStackTrace();
		} catch (IOException e)
		{
			
			strReturn=null;
			CommonUtil.errorSet(e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		return strReturn;
	}
	
	
	public void findAllEmployee(AjaxBehaviorEvent event) 
	{
//		EmployeeDelegate employeeDelegate=new EmployeeDelegate();
		try 
		{
			listEmployees=EmployeeMapper.getListTOFromListEntity(employeeBS.findAllActiveEmployee());
			System.out.println(listEmployees);
			System.out.println(listEmployees.iterator().next().getFirstName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void delete(ActionEvent event)
	{
		List<Long> arlEmployeeId=new ArrayList<Long>();
		
//		EmployeeDelegate employeeDelegate=new EmployeeDelegate();
		
		for (EmployeeTO employeeTO : listEmployees) 
		{
			if(employeeTO.isSelectedEmployee())
			{
				System.out.println(employeeTO.getEmployeeId());
				arlEmployeeId.add( employeeTO.getEmployeeId());
			}
			
		}		
		 
		try 
		{
			employeeBS.delete(arlEmployeeId,10);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	public String edit()
	{	
		
		List<EmployeeTO> arlEmployeeTOs = new ArrayList<EmployeeTO>();
		
		for (EmployeeTO employeeTO : listEmployees) 
		{
			if(employeeTO.isSelectedEmployee())
			{
				System.out.println("employee add for edit");
				arlEmployeeTOs.add(employeeTO);
			}
			
		}	
		
		if(arlEmployeeTOs.size()< 0)
		{
			System.out.println("no employee selected ");
			return null;
		}
		
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("employeeTO",arlEmployeeTOs.iterator().next());
		
	
		/*EmployeeBean bean=new EmployeeBean();
		bean.setEmployeeTO(arlEmployeeTOs.iterator().next());*/
		return "register";
	}
	
	public String  add()
	{
		return  "register";		
	}
	
	public String logout()
	{
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		System.out.println("---logout----");
		return "login.xhtml?faces-redirect=true";
	}
	
}
