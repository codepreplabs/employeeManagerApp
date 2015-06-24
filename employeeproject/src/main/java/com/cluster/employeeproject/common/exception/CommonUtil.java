package com.cluster.employeeproject.common.exception;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.swing.text.rtf.RTFEditorKit;

import com.cluster.employeeproject.common.managedbean.BaseBean;


public class CommonUtil
{
	public static FacesMessage errorSet(Exception exception)
	{
		System.out.println("22222222222222222222222222");
		
		if(exception instanceof EmployeeManagementApplicationException)
		{
			EmployeeManagementApplicationException applicationException=(EmployeeManagementApplicationException)exception;
			System.out.println("---- exception "+exception);
			System.out.println("Resource bundle "+BaseBean.resourceBundle);
			System.out.println("error messsage "+BaseBean.resourceBundle.getString(applicationException.getErrorKey()));
		    FacesMessage facesMessage=new FacesMessage(BaseBean.resourceBundle.getString(applicationException.getErrorKey()));
		    
//			FacesMessage facesMessage=new FacesMessage(BaseBean.resourceBundle.getString(applicationException.getErrorKey()));
			facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("form", facesMessage);
			System.out.println("facesmessage set");
			return facesMessage;
		}
		else if (exception instanceof EmployeeManagementSecurityException)
		{
			EmployeeManagementSecurityException securityException=(EmployeeManagementSecurityException)exception;
			FacesMessage facesMessage=new FacesMessage(BaseBean.resourceBundle.getString(securityException.getErrorkey()));
			facesMessage.setSeverity(facesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			return facesMessage;
		}
		else
		{
			EmployeeManagementSystemException systemException=(EmployeeManagementSystemException)exception;
			FacesMessage facesMessage=new FacesMessage(BaseBean.resourceBundle.getString(systemException.getErrorkey()));
			facesMessage.setSeverity(facesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			return facesMessage;
		}
				
	}

}
