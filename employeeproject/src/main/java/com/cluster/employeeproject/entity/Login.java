package com.cluster.employeeproject.entity;

// Generated Feb 28, 2013 3:50:08 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cluster.employeeproject.common.entity.BaseDO;


/**
 * Login generated by hbm2java
 */
@Entity
@Table(name = "LOGIN", schema = "employeeproject")
public class Login  extends BaseDO implements java.io.Serializable {

	private long loginId;
	private Employee employee;
	private String username;
	private String password;
	private Date dateLastLogin;
	private long totalLoginAttempts;

	public Login() {
	}

	public Login(long loginId) {
		this.loginId = loginId;
	}

	public Login(long loginId, Employee employee, String username,
			String password, Date dateLastLogin, long totalLoginAttempts) {
		this.loginId = loginId;
		this.employee = employee;
		this.username = username;
		this.password = password;
		this.dateLastLogin = dateLastLogin;
		this.totalLoginAttempts = totalLoginAttempts;
	}

	@Id
	@Column(name = "LOGIN_ID", unique = true, nullable = false, precision = 22, scale = 0)
/*	@GeneratedValue(generator="login_seq")
	@SequenceGenerator(name="login_seq",sequenceName="LOGIN_SEQ")*/
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getLoginId() {
		return this.loginId;
	}

	public void setLoginId(long loginId) {
		this.loginId = loginId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EMPLOYEE_ID")
	public Employee getEmployee() {
		return this.employee;
	}

	

	@Column(name = "USERNAME", length = 50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "PASSWORD", length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	@Column(name = "DATE_LAST_LOGIN", length = 7)
	@Temporal(TemporalType.DATE)
	public Date getDateLastLogin() {
		return this.dateLastLogin;
	}

	public void setDateLastLogin(Date dateLastLogin) {
		this.dateLastLogin = dateLastLogin;
	}

	@Column(name = "TOTAL_LOGIN_ATTEMPTS", precision = 22, scale = 0)
	public long getTotalLoginAttempts() {
		return this.totalLoginAttempts;
	}

	public void setTotalLoginAttempts(long totalLoginAttempts) {
		this.totalLoginAttempts = totalLoginAttempts;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	

}
