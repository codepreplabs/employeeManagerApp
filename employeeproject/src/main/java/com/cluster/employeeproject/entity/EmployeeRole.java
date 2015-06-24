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
 * EmployeeRole generated by hbm2java
 */
@Entity
@Table(name = "EMPLOYEE_ROLE", schema = "employeeproject")
public class EmployeeRole extends BaseDO implements java.io.Serializable {

	private long employeeRoleId;
	private Employee employee;
	private Role role;
	private Status status;

	public EmployeeRole() {
	}

	public EmployeeRole(long employeeRoleId) {
		this.employeeRoleId = employeeRoleId;
	}

	public EmployeeRole(long employeeRoleId, Employee employee,
			Role role, Status status) {
		this.employeeRoleId = employeeRoleId;
		this.employee = employee;
		this.role = role;
		this.status = status;
	}

	@Id
	@Column(name = "EMPLOYEE_ROLE_ID", unique = true, nullable = false, precision = 22, scale = 0)
	/*@SequenceGenerator(name="employeeRole", sequenceName="EMPLOYEE_ROLE_SEQ")
	@GeneratedValue(generator="employeeRole")*/
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getEmployeeRoleId() {
		return this.employeeRoleId;
	}

	public void setEmployeeRoleId(long employeeRoleId) {
		this.employeeRoleId = employeeRoleId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EMPLOYEE_ID")
	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ROLE_ID")
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "STATUS_ID")
	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}