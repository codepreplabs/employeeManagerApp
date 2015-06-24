package com.cluster.employeeproject.web.employee.to;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.cluster.employeeproject.entity.City;
import com.cluster.employeeproject.entity.Country;
import com.cluster.employeeproject.entity.Department;
import com.cluster.employeeproject.entity.Employee;
import com.cluster.employeeproject.entity.Role;
import com.cluster.employeeproject.entity.State;

public class EmployeeTO 
{
	private long employeeId;
	private long permanentAddressId;
	private long temporaryAddressId;
	private long landlineNumberId;
	private long moblieNumberId;
	private long officeNumberId;
	private long employeeRoleId;
	
	private long loginAttempts;
	private Date lastLoginDate;
	
	private long loginId;
	private String firstName;
	private String lastName;
	private String middleName;
	private String gender;
	private Date   dob;
	private byte[] image;
	private long   statusSelected;
	
	public byte[] getImage()
	{
		System.out.println("getImage of EmployeeTO"+image);
		return image;
	}
	
	public void setImage(byte[] img) throws IOException
	{
		this.image = img;
		System.out.println("setImage of employeeTO"+image);
		/*System.out.println("image length"+this.image.length);
		
		 FileOutputStream fileOutputStream=new FileOutputStream("C:/Users/Admin/Desktop/testproject/imageTO.jpg");
		 
			fileOutputStream.write(this.image);*/
		
	}
	private String emailId;
	private String alternateEmailId;
	
	private String userName;
	private String password;
	
	private String landlineNumber;
	private String mobileNumber;
	private String officeNumber;
	
	private String permanentAddressline1;
	private String permanentAddressline2;
	private String temporaryAddressline1;
	private String temporaryAddressline2;
	private long permanentCityId;
	private long temporaryCityId;
	
	private String departmentName;
	private List<Employee> arlEmployeeTOs;
	
	private long roleSelected;
	private long departmentSelected;
	private long countrySelected;
	private long stateSelected;
	private long citySelected;
	
	private List<Department> arlDepartments;
	private List<Country> arlCountries;
	private List<State> arlStates;
	private List<City> arlCities;
	private List<Role> arlRoles;
	
	private String localCountry;
	private String localeState;
	private String localCity;
	private  long  localZipcode;
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAlternateEmailId() {
		return alternateEmailId;
	}
	public void setAlternateEmailId(String alternateEmailId) {
		this.alternateEmailId = alternateEmailId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLandlineNumber() {
		return landlineNumber;
	}
	public void setLandlineNumber(String landlineNumber) {
		this.landlineNumber = landlineNumber;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getOfficeNumber() {
		return officeNumber;
	}
	public void setOfficeNumber(String officeNumber) {
		this.officeNumber = officeNumber;
	}
	public String getPermanentAddressline1() {
		return permanentAddressline1;
	}
	public void setPermanentAddressline1(String permanentAddressline1) {
		this.permanentAddressline1 = permanentAddressline1;
	}
	public String getPermanentAddressline2() {
		return permanentAddressline2;
	}
	public void setPermanentAddressline2(String permanentAddressline2) {
		this.permanentAddressline2 = permanentAddressline2;
	}
	public String getTemporaryAddressline1() {
		return temporaryAddressline1;
	}
	public void setTemporaryAddressline1(String temporaryAddressline1) {
		this.temporaryAddressline1 = temporaryAddressline1;
	}
	public String getTemporaryAddressline2() {
		return temporaryAddressline2;
	}
	public void setTemporaryAddressline2(String temporaryAddressline2) {
		this.temporaryAddressline2 = temporaryAddressline2;
	}
	public long getPermanentCityId() {
		return permanentCityId;
	}
	public void setPermanentCityId(long permanentCityId) {
		this.permanentCityId = permanentCityId;
	}
	public long getTemporaryCityId() {
		return temporaryCityId;
	}
	public void setTemporaryCityId(long temporaryCityId) {
		this.temporaryCityId = temporaryCityId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public List<Employee> getArlEmployeeTOs() {
		return arlEmployeeTOs;
	}
	public void setArlEmployeeTOs(List<Employee> arlEmployeeTOs) {
		this.arlEmployeeTOs = arlEmployeeTOs;
	}
	public long getRoleSelected() {
		return roleSelected;
	}
	public void setRoleSelected(long roleSelected) {
		this.roleSelected = roleSelected;
	}
	public long getDepartmentSelected() {
		return departmentSelected;
	}
	public void setDepartmentSelected(long departmentSelected) {
		this.departmentSelected = departmentSelected;
	}
	public long getCountrySelected() {
		return countrySelected;
	}
	public void setCountrySelected(long countrySelected) {
		this.countrySelected = countrySelected;
	}
	public long getStateSelected() {
		return stateSelected;
	}
	public void setStateSelected(long stateSelected) {
		this.stateSelected = stateSelected;
	}
	public long getCitySelected() {
		return citySelected;
	}
	public void setCitySelected(long citySelected) {
		this.citySelected = citySelected;
	}
	public List<Department> getArlDepartments() {
		return arlDepartments;
	}
	public void setArlDepartments(List<Department> arlDepartments) {
		this.arlDepartments = arlDepartments;
	}
	public List<Country> getArlCountries() {
		return arlCountries;
	}
	public void setArlCountries(List<Country> arlCountries) {
		this.arlCountries = arlCountries;
	}
	public List<State> getArlStates() {
		return arlStates;
	}
	public void setArlStates(List<State> arlStates) {
		this.arlStates = arlStates;
	}
	public List<City> getArlCities() {
		return arlCities;
	}
	public void setArlCities(List<City> arlCities) {
		this.arlCities = arlCities;
	}
	public List<Role> getArlRoles() {
		return arlRoles;
	}
	public void setArlRoles(List<Role> arlRoles) {
		this.arlRoles = arlRoles;
	}
	public String getLocalCountry() {
		return localCountry;
	}
	public void setLocalCountry(String localCountry) {
		this.localCountry = localCountry;
	}
	public String getLocaleState() {
		return localeState;
	}
	public void setLocaleState(String localeState) {
		this.localeState = localeState;
	}
	public String getLocalCity() {
		return localCity;
	}
	public void setLocalCity(String localCity) {
		this.localCity = localCity;
	}
	public long getLocalZipcode() {
		return localZipcode;
	}
	public void setLocalZipcode(long localZipcode) {
		this.localZipcode = localZipcode;
	}
	
	
	private boolean selectedEmployee;

	public boolean isSelectedEmployee() {
		return selectedEmployee;
	}

	public void setSelectedEmployee(boolean selectedEmployee) {
		this.selectedEmployee = selectedEmployee;
	}

	public long getPermanentAddressId() {
		return permanentAddressId;
	}

	public void setPermanentAddressId(long permanentAddressId) {
		this.permanentAddressId = permanentAddressId;
	}

	public long getTemporaryAddressId() {
		return temporaryAddressId;
	}

	public void setTemporaryAddressId(long temporaryAddressId) {
		this.temporaryAddressId = temporaryAddressId;
	}

	public long getLandlineNumberId() {
		return landlineNumberId;
	}

	public void setLandlineNumberId(long landlineNumberId) {
		this.landlineNumberId = landlineNumberId;
	}

	public long getMoblieNumberId() {
		return moblieNumberId;
	}

	public void setMoblieNumberId(long moblieNumberId) {
		this.moblieNumberId = moblieNumberId;
	}

	public long getOfficeNumberId() {
		return officeNumberId;
	}

	public void setOfficeNumberId(long officeNumberId) {
		this.officeNumberId = officeNumberId;
	}

	public long getLoginId() {
		return loginId;
	}

	public void setLoginId(long loginId) {
		this.loginId = loginId;
	}

	public long getEmployeeRoleId() {
		return employeeRoleId;
	}

	public void setEmployeeRoleId(long employeeRoleId) {
		this.employeeRoleId = employeeRoleId;
	}

	public long getStatusSelected() {
		return statusSelected;
	}

	public void setStatusSelected(long statusSelected) {
		this.statusSelected = statusSelected;
	}

	public long getLoginAttempts() {
		return loginAttempts;
	}

	public void setLoginAttempts(long loginAttempts) {
		this.loginAttempts = loginAttempts;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	
	
	
	
	
	
}
