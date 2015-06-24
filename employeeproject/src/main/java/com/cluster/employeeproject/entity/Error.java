package com.cluster.employeeproject.entity;

// Generated Feb 28, 2013 3:50:08 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cluster.employeeproject.common.entity.BaseDO;

/**
 * Error generated by hbm2java
 */
@Entity
@Table(name = "ERROR", schema = "employeeproject")
public class Error extends BaseDO implements java.io.Serializable {

	private long errorId;
	private String className;
	private String methodName;
	private long linenumber;
	private String exceptionalMessage;
	private String exceptionalType;
	private Date errorDate;

	public Error() {
	}

	public Error(long errorId) {
		this.errorId = errorId;
	}

	public Error(long errorId, String className, String methodName,
			long linenumber, String exceptionalMessage,
			String exceptionalType, Date errorDate) {
		this.errorId = errorId;
		this.className = className;
		this.methodName = methodName;
		this.linenumber = linenumber;
		this.exceptionalMessage = exceptionalMessage;
		this.exceptionalType = exceptionalType;
		this.errorDate = errorDate;
	}

	@Id
	@Column(name = "ERROR_ID", unique = true, nullable = false, precision = 22, scale = 0)
/*	@SequenceGenerator(name="error", sequenceName="ERROR_SEQ")
	@GeneratedValue(generator="error")*/
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getErrorId() {
		return this.errorId;
	}

	public void setErrorId(long errorId) {
		this.errorId = errorId;
	}

	@Column(name = "CLASS_NAME", length = 200)
	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Column(name = "METHOD_NAME", length = 200)
	public String getMethodName() {
		return this.methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	@Column(name = "LINENUMBER", precision = 22, scale = 0)
	public long getLinenumber() {
		return this.linenumber;
	}

	public void setLinenumber(long linenumber) {
		this.linenumber = linenumber;
	}

	@Column(name = "EXCEPTIONAL_MESSAGE", length = 200)
	public String getExceptionalMessage() {
		return this.exceptionalMessage;
	}

	public void setExceptionalMessage(String exceptionalMessage) {
		this.exceptionalMessage = exceptionalMessage;
	}

	@Column(name = "EXCEPTIONAL_TYPE", length = 200)
	public String getExceptionalType() {
		return this.exceptionalType;
	}

	public void setExceptionalType(String exceptionalType) {
		this.exceptionalType = exceptionalType;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ERROR_DATE", length = 7)
	public Date getErrorDate() {
		return this.errorDate;
	}

	public void setErrorDate(Date errorDate) {
		this.errorDate = errorDate;
	}

}