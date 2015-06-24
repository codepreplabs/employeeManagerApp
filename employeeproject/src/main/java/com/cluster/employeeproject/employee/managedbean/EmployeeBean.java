package com.cluster.employeeproject.employee.managedbean;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.cluster.employeeproject.common.exception.CommonUtil;
import com.cluster.employeeproject.common.exception.EmployeeManagementApplicationException;
import com.cluster.employeeproject.employee.businessservice.EmployeeBS;
import com.cluster.employeeproject.entity.Employee;
import com.cluster.employeeproject.web.employee.mapper.EmployeeMapper;
import com.cluster.employeeproject.web.employee.to.EmployeeTO;

/*@ManagedBean(name="employeeBean")
@RequestScoped*/
@Component
@Scope("request")
public class EmployeeBean
{
	@Autowired
	EmployeeBS employeeBS;
	EmployeeTO employeeTO;	
	private UploadedFile files ;
	private byte[] image;
	private boolean updating;
	
	
	@PostConstruct
	public void init()
	{
		employeeTO=(EmployeeTO) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("employeeTO");
		
//		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("employeeTO");
		System.out.println("employee in inti() "+employeeTO);
		if(employeeTO!=null)
		{
			System.out.println("employeebean update");
			updating=true;
			
		}
		if(employeeTO==null)
		{
			System.out.println("---------");
			employeeTO=new EmployeeTO();
		}	
			
	}
	
	
	
	private static Map<String,String> countries;
	private  static Map<String,String> states;
	private static Map<String,String> cities;
	
	
	static
	{
		countries=new HashMap<String, String>();
		countries.put("India","10");
		countries.put("America","20");
		countries.put("SriLanka","30");
		countries.put("Pakistan","40");	
		ApplicationMap.init();
	}
	
	

	public  Map<String, String> getCountries() {
		return countries;
	}

	public void setCountries(Map<String, String> countries) {
		EmployeeBean.countries = countries;
	}

	public  Map<String, String> getStates() {
		return states;
	}

	public void setStates(Map<String, String> states) {
		EmployeeBean.states = states;
	}
	
	
	
	
	

	public EmployeeTO getEmployeeTO() {
		return employeeTO;
	}

	public void setEmployeeTO(EmployeeTO employeeTO) {
		this.employeeTO = employeeTO;
	}

	public  Map<String, String> getCities() {
		return cities;
	}

	public  void setCities(Map<String, String> cities) {
		EmployeeBean.cities = cities;
	}

	
	public UploadedFile getFiles() {
		return files;
	}
	public void setFiles(UploadedFile files) {
		this.files = files;
	}
	
	

	public void valueChangedCountry(ValueChangeEvent event)
	{
		System.out.println("inside valueChangedCountry ");
		String newCountry=event.getNewValue().toString();
		
		System.out.println("Country "+newCountry);
		if(newCountry.equalsIgnoreCase("10"))
		{
			states=new HashMap<String, String>();
			states.put("Assam","10");
			states.put("Gujarat","20");
			states.put("Delhi","30");
			states.put("Kerala","40");
			states.put("Karnataka","50");
			states.put("Maharashtra","60");			
		}
		if(newCountry.equalsIgnoreCase("20"))
		{
			states=new HashMap<String, String>();
			states.put("NewYork","NewYork");
			states.put("Califonia","Califonia");
			states.put("Washington","Washinaton");
		}
		if(newCountry.equalsIgnoreCase("40"))
		{
			states=new HashMap<String, String>();
			states.put("Karachi","Karachi");
			states.put("Lahore","Lahore");
			states.put("Multan","Multan");
		}
		if(newCountry.equalsIgnoreCase("30"))
		{
			states=new HashMap<String, String>();
			states.put("Colombo","Colombo");
			states.put("Jaffan","Jaffan");
						
		}
		
		
	}
	
	
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	

	public boolean isUpdating() {
		return updating;
	}

	public void setUpdating(boolean updating) {
		this.updating = updating;
	}

	public void valueChangedState(ValueChangeEvent event)
	{
		System.out.println("inside state valuechage event");
		
		String newState=event.getNewValue().toString();
		
		String value=  getkey(getStates(), newState);
		
		System.out.println("selected state is " +value);
		
		
		
		
		/*if(newState.equalsIgnoreCase("60"))
		{
			Map<String, Object> appMap=FacesContext.getCurrentInstance().getExternalContext().getApplicationMap();
			 setCities((Map<String, String>) appMap.get("maharashtra"));
			
		}
		if(newState.equalsIgnoreCase("20"))
		{
			Map<String, Object> appMap=FacesContext.getCurrentInstance().getExternalContext().getApplicationMap();
			 setCities((Map<String, String>) appMap.get("gujrat"));
			
		}
		if(newState.equalsIgnoreCase("50"))
		{
			Map<String, Object> appMap=FacesContext.getCurrentInstance().getExternalContext().getApplicationMap();
			 setCities((Map<String, String>) appMap.get("karanataka"));
			 
			
		}*/
		
		
			Map<String, Object> appMap=FacesContext.getCurrentInstance().getExternalContext().getApplicationMap();
			 setCities((Map<String, String>) appMap.get(value));
		
		
	}
	
	
	
	
	private String getkey(Map<String, String> states2, String newState) 
	{
		
		Iterator  map=states2.keySet().iterator();
		
		while (map.hasNext())
		{
			String key=(String) map.next();
			
			if(states2.get(key).equals(newState))
			{
				return key;
			}
			
		}
		return null;		
	}

	
	public void paint(OutputStream stream, Object object) throws IOException 
	{
//	stream.write(getFiles().getData());
		stream.write(image);
	stream.close();
	}
	
	public void listener(FileUploadEvent event) throws Exception
	{
		
		System.out.println("Inside file upload event");
		files= event.getUploadedFile();
		
		System.out.println("image file"+files);
		employeeTO.setImage(files.getData());
		System.out.println("file.getData() "+files.getData());
		image=files.getData();
	 
	 /*FileOutputStream fileOutputStream=new FileOutputStream("/image/imagesTO.jpg");
	 fileOutputStream.write(files.getData());*/
	 
	 
	 System.out.println("success");
	}
	
	public Date getTimeStamp(){
	return new Date();
	}
	
	
	public String save() 
	{
		String strReturn=null;
		System.out.println("save method of EmployeeBean");
		Employee employee= EmployeeMapper.getEntityFromTO(employeeTO);
		
		System.out.println("after employee mapper");
//		EmployeeDelegate employeeDelegate=new EmployeeDelegate();
		try {
			employeeBS.save(employee, 10);
			System.out.println("after employee delegate.save");
			strReturn="success";
		} catch (EmployeeManagementApplicationException e)
		{
			CommonUtil.errorSet(e);
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("employeeId"+employee.getEmployeeId());
		
		return "loginsuccess";
		
	}
	
	public String update() 
	{
		String strReturn=null;
        Employee employee= EmployeeMapper.getEntityFromTO(employeeTO);
		
		
//		EmployeeDelegate employeeDelegate=new EmployeeDelegate();
		try 
		{
			employeeBS.update(employee);
			
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("employeeId"+employee.getEmployeeId());
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("employeeTO");
		
		System.out.println("end of update() employeeTO "+employeeTO);
		if(updating)
		{
			strReturn="loginsuccess";
			
		}
		
		return strReturn;
	}
	
	@PreDestroy
	public void destroy()
	{
		employeeTO=null;		
		
	}
	
	
	

}
