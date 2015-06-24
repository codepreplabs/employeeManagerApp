package com.cluster.employeeproject.web.employee.mapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.cluster.employeeproject.common.constant.EmployeeConstant;
import com.cluster.employeeproject.entity.AddressType;
import com.cluster.employeeproject.entity.City;
import com.cluster.employeeproject.entity.Department;
import com.cluster.employeeproject.entity.Employee;
import com.cluster.employeeproject.entity.EmployeeAddress;
import com.cluster.employeeproject.entity.EmployeePhone;
import com.cluster.employeeproject.entity.EmployeeRole;
import com.cluster.employeeproject.entity.Login;
import com.cluster.employeeproject.entity.PhoneType;
import com.cluster.employeeproject.entity.Role;
import com.cluster.employeeproject.entity.Status;
import com.cluster.employeeproject.web.employee.to.EmployeeTO;


public class EmployeeMapper 
{
	public static Employee getEntityFromTO(EmployeeTO pEmployeeTO)
	{
		Employee employee=new Employee();
		
		if(pEmployeeTO.getEmployeeId() >0)
		{
			employee.setEmployeeId(pEmployeeTO.getEmployeeId());			
		}
		
		employee.setFirstName(pEmployeeTO.getFirstName());
		employee.setLastName(pEmployeeTO.getLastName());
		employee.setMiddleName(pEmployeeTO.getMiddleName());
		employee.setGender(pEmployeeTO.getGender());
		
		employee.setDob(pEmployeeTO.getDob());
		
		employee.setEmailId(pEmployeeTO.getEmailId());
		employee.setAlternateEmailId(pEmployeeTO.getAlternateEmailId());
		
		
		Department department=new Department();
		department.setDepartmentId(pEmployeeTO.getDepartmentSelected());
		employee.setDepartment(department);
		
		
		
		Status status=new Status();
		status.setStatusId(EmployeeConstant.STATUS_ACTIVE.getConstantValue());
		employee.setStatus(status);
		
		
		Set<Employee> hsEmployees=new HashSet<Employee>();
		hsEmployees.add(employee);
		
		department.setEmployees(hsEmployees);
		
		Set<EmployeeAddress> hsEmployeeAddresses=new HashSet<EmployeeAddress>();
		
		
		if(!(pEmployeeTO.getPermanentAddressline1().equals(null) || pEmployeeTO.getPermanentAddressline2().equals(null)))
		{
			EmployeeAddress employeeAddress=new EmployeeAddress();
			if(pEmployeeTO.getPermanentAddressId()!=0)
			{
				System.out.println("emporary permenantAddressId "+pEmployeeTO.getPermanentAddressId());
				employeeAddress.setEmployeeAddressId(pEmployeeTO.getPermanentAddressId());
			
			}
			employeeAddress.setAddressline1(pEmployeeTO.getPermanentAddressline1());
			employeeAddress.setAddressline2(pEmployeeTO.getPermanentAddressline2());
			employeeAddress.setZipcode(pEmployeeTO.getLocalZipcode());
			employeeAddress.setEmployee(employee);
		
			
			AddressType addressType=new AddressType();
			addressType.setAddressTypeId(EmployeeConstant.PERMANENT.getConstantValue());
			addressType.setEmployeeAddresses(hsEmployeeAddresses);
			
			City city=new City();
			city.setCityId(pEmployeeTO.getCitySelected());
			city.setEmployeeAddresses(hsEmployeeAddresses);
			
			employeeAddress.setCity(city);
			employeeAddress.setAddressType(addressType);			
			
			employee.setEmployeeAddresses(hsEmployeeAddresses);			
			hsEmployeeAddresses.add(employeeAddress);
			
			
			
		}
		
		if(!(pEmployeeTO.getTemporaryAddressline1().equals(null) || pEmployeeTO.getTemporaryAddressline2().equals(null)))
		{
			EmployeeAddress employeeAddress2=new EmployeeAddress();
			if(pEmployeeTO.getTemporaryAddressId()!=0)
			{
				System.out.println("employeeTO temporaryaddressId "+pEmployeeTO.getTemporaryAddressId());
				employeeAddress2.setEmployeeAddressId(pEmployeeTO.getTemporaryAddressId());
			
			}
			
			employeeAddress2.setAddressline1(pEmployeeTO.getTemporaryAddressline1());
			employeeAddress2.setAddressline2(pEmployeeTO.getTemporaryAddressline2());
			employeeAddress2.setZipcode(pEmployeeTO.getLocalZipcode());
			employeeAddress2.setEmployee(employee);
			
		    City city=new City();
		    city.setCityId(pEmployeeTO.getCitySelected());
		    city.setEmployeeAddresses(hsEmployeeAddresses);
		    
		    AddressType addressType2=new AddressType();
		    addressType2.setAddressTypeId(EmployeeConstant.TEMPORARY.getConstantValue());
		    addressType2.setEmployeeAddresses(hsEmployeeAddresses);
		    
		    employeeAddress2.setCity(city);
		    employeeAddress2.setAddressType(addressType2);
		    hsEmployeeAddresses.add(employeeAddress2);
		    employee.setEmployeeAddresses(hsEmployeeAddresses); 
		    
			
			
		}
		
		Set<EmployeePhone> hsEmployeePhones=new HashSet<EmployeePhone>();
		
		if(!pEmployeeTO.getMobileNumber().equals(null))
		{
			System.out.println("moblie number id "+pEmployeeTO.getMoblieNumberId());
			EmployeePhone employeePhone=new EmployeePhone();
			employeePhone.setEmployeePhoneId(pEmployeeTO.getMoblieNumberId());
			employeePhone.setPhoneNo(pEmployeeTO.getMobileNumber());
			employeePhone.setEmployee(employee);
			
			PhoneType phoneType=new PhoneType();
			phoneType.setPhoneTypeId(EmployeeConstant.PHONE_TYPE_MOBILE.getConstantValue());
			phoneType.setEmployeePhones(hsEmployeePhones);
			
			employeePhone.setPhoneType(phoneType);
			hsEmployeePhones.add(employeePhone);	
			
			employee.setEmployeePhones(hsEmployeePhones);
			
			
		}
		
		if(!pEmployeeTO.getOfficeNumber().equals(null))
		{
			System.out.println("office id "+pEmployeeTO.getOfficeNumberId());
			EmployeePhone employeePhone=new EmployeePhone();
			employeePhone.setEmployeePhoneId(pEmployeeTO.getOfficeNumberId());
			employeePhone.setPhoneNo(pEmployeeTO.getOfficeNumber());
			employeePhone.setEmployee(employee);
			
			PhoneType phoneType=new PhoneType();
			phoneType.setPhoneTypeId(EmployeeConstant.PHONE_TYPE_OFFICE.getConstantValue());
			phoneType.setEmployeePhones(hsEmployeePhones);
			
			employeePhone.setPhoneType(phoneType);
			hsEmployeePhones.add(employeePhone);	
			employee.setEmployeePhones(hsEmployeePhones);
			
		}
		
		if(!pEmployeeTO.getLandlineNumber().equals(null))
		{
			System.out.println("landline id "+pEmployeeTO.getLandlineNumberId());
			EmployeePhone employeePhone=new EmployeePhone();
			employeePhone.setEmployeePhoneId(pEmployeeTO.getLandlineNumberId());
			employeePhone.setPhoneNo(pEmployeeTO.getLandlineNumber());
			employeePhone.setEmployee(employee);
			
			PhoneType phoneType=new PhoneType();
			phoneType.setPhoneTypeId(EmployeeConstant.PHONE_TYPE_HOME.getConstantValue());
			phoneType.setEmployeePhones(hsEmployeePhones);
			
			employeePhone.setPhoneType(phoneType);
			hsEmployeePhones.add(employeePhone);	
			employee.setEmployeePhones(hsEmployeePhones);
			
		}
		
		
		Login login=new Login();
		login.setLoginId(pEmployeeTO.getLoginId());
		login.setUsername(pEmployeeTO.getUserName());
		login.setPassword(pEmployeeTO.getPassword());
		
		login.setTotalLoginAttempts(pEmployeeTO.getLoginAttempts());
		if(pEmployeeTO.getLastLoginDate()!=new Date())
		{
			login.setDateLastLogin(pEmployeeTO.getLastLoginDate());
		}
		else
		{
			login.setDateLastLogin(new Date(System.currentTimeMillis()));
		}
		
		login.setEmployee(employee);
		
		Set<Login> hsLogins=new HashSet<Login>();
		hsLogins.add(login);
		
		employee.setLogins(hsLogins);
		
		Role role=new Role();
		role.setRoleId(pEmployeeTO.getRoleSelected());
		
		EmployeeRole employeeRole=new EmployeeRole();
		employeeRole.setEmployeeRoleId(pEmployeeTO.getEmployeeRoleId());
		
		employeeRole.setRole(role);
		employeeRole.setEmployee(employee);
		employeeRole.setStatus(status);
		
		Set<EmployeeRole> hsEmployeeRoles=new HashSet<EmployeeRole>();
		hsEmployeeRoles.add(employeeRole);
		employee.setEmployeeRoles(hsEmployeeRoles);
	/*	if(pEmployeeTO.getImage().length!=0)
		{
			
			employee.setImage(pEmployeeTO.getImage());
			System.out.println("image in employee"+employee.getImage().length);
			
		}*/
		
		employee.setImage(pEmployeeTO.getImage());
		
		
		return employee;
	}

	public static List<EmployeeTO> getListTOFromListEntity(List<Employee> pArlEmployee) throws IOException
	{
		System.out.println("---------begin getListTOFromListEntity() -------");
		List<EmployeeTO> arlEmployeeTOs=new ArrayList<EmployeeTO>();
		for (Employee employee : pArlEmployee) 
		{
			EmployeeTO employeeTO=new EmployeeTO();
			
			employeeTO.setEmployeeId(employee.getEmployeeId());
			employeeTO.setFirstName(employee.getFirstName());
			employeeTO.setLastName(employee.getLastName());
			employeeTO.setMiddleName(employee.getMiddleName());
			
			employeeTO.setDob(employee.getDob());
			employeeTO.setImage(employee.getImage());
		    employeeTO.setEmailId(employee.getEmailId());
		    employeeTO.setAlternateEmailId(employee.getAlternateEmailId());
		    
		   for (EmployeePhone employeePhone : employee.getEmployeePhones())
		   {
			   if(employeePhone.getPhoneType().getPhoneTypeId()==EmployeeConstant.PHONE_TYPE_MOBILE.getConstantValue())
			   {
				   System.out.println(" phoneid for moblie "+employeePhone.getEmployeePhoneId());
				   employeeTO.setMoblieNumberId(employeePhone.getEmployeePhoneId());
				   employeeTO.setMobileNumber(employeePhone.getPhoneNo());
			   }

			   if(employeePhone.getPhoneType().getPhoneTypeId()==EmployeeConstant.PHONE_TYPE_OFFICE.getConstantValue())
			   {
				   System.out.println(" phoneid for office "+employeePhone.getEmployeePhoneId());
				   employeeTO.setOfficeNumberId(employeePhone.getEmployeePhoneId());
				   employeeTO.setOfficeNumber(employeePhone.getPhoneNo());
			   }
			   if(employeePhone.getPhoneType().getPhoneTypeId()==EmployeeConstant.PHONE_TYPE_HOME.getConstantValue())
			   {
				   System.out.println(" phoneid for landline "+employeePhone.getEmployeePhoneId());
				   employeeTO.setLandlineNumberId(employeePhone.getEmployeePhoneId());
				   employeeTO.setLandlineNumber(employeePhone.getPhoneNo());
			   }			   
			
		   }
		   for(EmployeeAddress employeeAddress : employee.getEmployeeAddresses())
		   {
			   if(employeeAddress.getAddressType().getAddressTypeId()==EmployeeConstant.PERMANENT.getConstantValue())
			   {
				   employeeTO.setPermanentAddressId(employeeAddress.getEmployeeAddressId());
				   employeeTO.setPermanentAddressline1(employeeAddress.getAddressline1());
				   employeeTO.setPermanentAddressline2(employeeAddress.getAddressline2());		
				   employeeTO.setCitySelected(employeeAddress.getCity().getCityId());
			   }
			   if(employeeAddress.getAddressType().getAddressTypeId()==EmployeeConstant.TEMPORARY.getConstantValue())
			   {
				   employeeTO.setTemporaryAddressId(employeeAddress.getEmployeeAddressId());
				   employeeTO.setTemporaryAddressline1(employeeAddress.getAddressline1());
				   employeeTO.setTemporaryAddressline2(employeeAddress.getAddressline2());
				   employeeTO.setCitySelected(employeeAddress.getCity().getCityId());
			  }
			   	   
		   }
		   
		   for ( Login login : employee.getLogins())
		   {
			   if(login.getLoginId()!=0)
			   {
				   employeeTO.setLoginId(login.getLoginId());
				   
			   }
			   employeeTO.setUserName(login.getUsername());
			   employeeTO.setPassword(login.getPassword());
			   employeeTO.setLoginAttempts(login.getTotalLoginAttempts());
			   employeeTO.setLastLoginDate(login.getDateLastLogin());
			
		   }   
		   
		   for (EmployeeRole employeeRole : employee.getEmployeeRoles()) 
		   {
			   employeeTO.setEmployeeRoleId(employeeRole.getEmployeeRoleId());
			   employeeTO.setRoleSelected(employeeRole.getRole().getRoleId());
			   employeeTO.setStatusSelected(employeeRole.getStatus().getStatusId());
		   }
		
//		   employeeTO.setDepartmentName(employee.getDepartment().getDepartmentName());
		   employeeTO.setDepartmentSelected(employee.getDepartment().getDepartmentId());
		   arlEmployeeTOs.add(employeeTO);
			
			
		}
		System.out.println("---------End  getListTOFromListEntity() -------");
		return arlEmployeeTOs;
	}
	
	
	public static EmployeeTO getTOFromEntity(Employee employee) throws IOException
	{
		System.out.println("------begin of getTOFromEntity()-------");
		EmployeeTO employeeTO =new EmployeeTO();


		employeeTO.setFirstName(employee.getFirstName());
		employeeTO.setLastName(employee.getLastName());
		employeeTO.setMiddleName(employee.getMiddleName());
		employeeTO.setEmployeeId(employee.getEmployeeId());
		employeeTO.setDob(employee.getDob());
		employeeTO.setImage(employee.getImage());
	    employeeTO.setEmailId(employee.getEmailId());
	    employeeTO.setAlternateEmailId(employee.getAlternateEmailId());
	    
	    for (EmployeePhone employeePhone : employee.getEmployeePhones())
		   {
			   if(employeePhone.getPhoneType().getPhoneTypeId()==EmployeeConstant.PHONE_TYPE_MOBILE.getConstantValue())
			   {
				  
				   employeeTO.setMobileNumber(employeePhone.getPhoneNo());
			   }
			   
			   if(employeePhone.getPhoneType().getPhoneTypeId()==EmployeeConstant.PHONE_TYPE_OFFICE.getConstantValue())
			   {
				   employeeTO.setOfficeNumber(employeePhone.getPhoneNo());
			   }
			   if(employeePhone.getPhoneType().getPhoneTypeId()==EmployeeConstant.PHONE_TYPE_HOME.getConstantValue())
			   {
				   employeeTO.setLandlineNumber(employeePhone.getPhoneNo());
			   }
			   
			   
		   }
		
		   employeeTO.setDepartmentName(employee.getDepartment().getDepartmentName());
		
		   System.out.println("------End of getTOFromEntity()-------");
		return employeeTO;
	}
	
	
}
