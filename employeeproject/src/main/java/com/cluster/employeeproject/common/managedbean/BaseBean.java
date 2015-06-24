package com.cluster.employeeproject.common.managedbean;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ApplicationScoped
public class BaseBean 
{
	
	public static ResourceBundle resourceBundle;
	
	static
	{
		System.out.println("Inside the BaseBean");
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String messageBundleName = facesContext.getApplication().getMessageBundle();
//		Locale locale = facesContext.getViewRoot().getLocale();
		System.out.println("messageBundleName "+messageBundleName);
		resourceBundle = ResourceBundle.getBundle(messageBundleName);
	}
	
	public BaseBean() 
	{
//		System.out.println("Inside the BaseBean");
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String messageBundleName = facesContext.getApplication().getMessageBundle();
//		Locale locale = facesContext.getViewRoot().getLocale();
		resourceBundle = ResourceBundle.getBundle(messageBundleName);
		
//    	resourceBundle=FacesContext.getCurrentInstance().getApplication().getResourceBundle(FacesContext.getCurrentInstance(),"myapp.ErrorMessage");
//		resourceBundle=ResourceBundle.getBundle("myapp.ErrorMessage");
	}

}
