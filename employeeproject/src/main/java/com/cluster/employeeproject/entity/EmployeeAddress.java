package com.cluster.employeeproject.entity;

// Generated Feb 28, 2013 3:50:08 PM by Hibernate Tools 3.4.0.CR1


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.cluster.employeeproject.common.entity.BaseDO;

/**
 * EmployeeAddress generated by hbm2java
 */
@Entity
@Table(name = "EMPLOYEE_ADDRESS", schema = "employeeproject")
public class EmployeeAddress extends BaseDO implements java.io.Serializable {

	private long employeeAddressId;
	private Employee employee;
	private AddressType addressType;
	private City city;
	private String addressline1;
	private String addressline2;
	private long zipcode;

	public EmployeeAddress() {
	}

	public EmployeeAddress(long employeeAddressId) {
		this.employeeAddressId = employeeAddressId;
	}

	public EmployeeAddress(long employeeAddressId, Employee employee,
			AddressType addressType, City city, String addressline1,
			String addressline2, long zipcode) {
		this.employeeAddressId = employeeAddressId;
		this.employee = employee;
		this.addressType = addressType;
		this.city = city;
		this.addressline1 = addressline1;
		this.addressline2 = addressline2;
		this.zipcode = zipcode;
	}

	@Id
	@Column(name = "EMPLOYEE_ADDRESS_ID", unique = true)
	/*@SequenceGenerator(name="employeeAddress", sequenceName="EMPLOYEE_ADDRESS_SEQ")
	@GeneratedValue(generator="employeeAddress")*/
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getEmployeeAddressId() {
		return this.employeeAddressId;
	}

	public void setEmployeeAddressId(long employeeAddressId) {
		this.employeeAddressId = employeeAddressId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EMPLOYEE_ID",updatable=true)
	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ADDRESS_TYPE_ID")
	public AddressType getAddressType() {
		return this.addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CITY_ID")
	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Column(name = "ADDRESSLINE1", length = 50)
	public String getAddressline1() {
		return this.addressline1;
	}

	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}

	@Column(name = "ADDRESSLINE2", length = 50)
	public String getAddressline2() {
		return this.addressline2;
	}

	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}

	@Column(name = "ZIPCODE", precision = 22, scale = 0)
	public long getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(long zipcode) {
		this.zipcode = zipcode;
	}

}
