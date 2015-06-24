package com.cluster.employeeproject.employee.managedbean;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@ApplicationScoped
public class ApplicationMap 
{
	static Map<String,String> citiesOfMaharastra;
	static Map<String,String> citiesOfGujarat;
	static Map<String,String> citieOfKaranataka;
	
	static
	{
		citiesOfMaharastra=new HashMap<String, String>();
		citiesOfMaharastra.put("Pune","10");
		citiesOfMaharastra.put("Nagpure","20");
		citiesOfMaharastra.put("Mumbai","30");
		citiesOfMaharastra.put("Lonavala","40");	
		
		citiesOfGujarat=new HashMap<String, String>();
		citiesOfGujarat.put("Ahmedabad", "50");
		citiesOfGujarat.put("Surat", "40");
		citiesOfGujarat.put("Vadodara / Baroda", "70");
		
		citieOfKaranataka=new HashMap<String, String>();
		citieOfKaranataka.put("Bangalore","10");
		citieOfKaranataka.put("Hubali","20");
		citieOfKaranataka.put("Bidar", "30");
		
		
		
		
		
	}
	
	
	public static void init()
	{
		Map<String,Object> appMap=FacesContext.getCurrentInstance().getExternalContext().getApplicationMap();
		appMap.put("Maharashtra",citiesOfMaharastra);
		appMap.put("Gujarat", citiesOfGujarat);
		appMap.put("Karnataka",citieOfKaranataka);
		
	}

}
