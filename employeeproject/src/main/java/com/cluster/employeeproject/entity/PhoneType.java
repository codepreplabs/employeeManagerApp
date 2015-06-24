package com.cluster.employeeproject.entity;

// Generated Feb 28, 2013 3:50:08 PM by Hibernate Tools 3.4.0.CR1


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cluster.employeeproject.common.entity.BaseDO;

/**
 * PhoneType generated by hbm2java
 */
@Entity
@Table(name = "PHONE_TYPE", schema = "employeeproject")
public class PhoneType extends BaseDO  implements java.io.Serializable {

	private long phoneTypeId;
	private String phoneType;
	private Set<EmployeePhone> employeePhones = new HashSet<EmployeePhone>(0);

	public PhoneType() {
	}

	public PhoneType(long phoneTypeId) {
		this.phoneTypeId = phoneTypeId;
	}

	public PhoneType(long phoneTypeId, String phoneType,
			Set<EmployeePhone> employeePhones) {
		this.phoneTypeId = phoneTypeId;
		this.phoneType = phoneType;
		this.employeePhones = employeePhones;
	}

	@Id
	@Column(name = "PHONE_TYPE_ID", unique = true, nullable = false, precision = 22, scale = 0)
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getPhoneTypeId() {
		return this.phoneTypeId;
	}

	public void setPhoneTypeId(long phoneTypeId) {
		this.phoneTypeId = phoneTypeId;
	}

	@Column(name = "PHONE_TYPE", length = 50)
	public String getPhoneType() {
		return this.phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "phoneType",cascade=CascadeType.ALL)
	public Set<EmployeePhone> getEmployeePhones() {
		return this.employeePhones;
	}

	public void setEmployeePhones(Set<EmployeePhone> employeePhones) {
		this.employeePhones = employeePhones;
	}

}
