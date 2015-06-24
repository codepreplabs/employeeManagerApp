package com.cluster.employeeproject.entity;

// Generated Feb 28, 2013 3:50:08 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
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
 * EmployeePhone generated by hbm2java
 */
@Entity
@Table(name = "EMPLOYEE_PHONE", schema = "employeeproject")
public class EmployeePhone extends BaseDO implements java.io.Serializable {

	private long employeePhoneId;
	private PhoneType phoneType;
	private Employee employee;
	private String phoneNo;

	public EmployeePhone() {
	}

	public EmployeePhone(long employeePhoneId) {
		this.employeePhoneId = employeePhoneId;
	}

	public EmployeePhone(long employeePhoneId, PhoneType phoneType,
			Employee employee, String phoneNo) {
		this.employeePhoneId = employeePhoneId;
		this.phoneType = phoneType;
		this.employee = employee;
		this.phoneNo = phoneNo;
	}

	@Id
	@Column(name = "EMPLOYEE_PHONE_ID", unique = true, nullable = false, precision = 22, scale = 0)
	/*@SequenceGenerator(name="employeePhone", sequenceName="EMPLOYEE_PHONE_SEQ")
	@GeneratedValue(generator="employeePhone")*/
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getEmployeePhoneId() {
		return this.employeePhoneId;
	}

	public void setEmployeePhoneId(long employeePhoneId) {
		this.employeePhoneId = employeePhoneId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PHONE_TYPE_ID")
	public PhoneType getPhoneType() {
		return this.phoneType;
	}

	public void setPhoneType(PhoneType phoneType) {
		this.phoneType = phoneType;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EMPLOYEE_ID")
	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Column(name = "PHONE_NO", length = 50)
	public String getPhoneNo() {
		return this.phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

}
