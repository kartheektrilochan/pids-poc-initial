package com.pids.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the USERS database table.
 * 
 */
@Entity
@Table(name="USERS")
@NamedQueries({
			@NamedQuery(name="User.findAll", query="SELECT u FROM User u"),
			@NamedQuery(name="User.findByDeviceId", query="SELECT u FROM User u where u.deviceId=:deviceId")
			})

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USERS_ID_GENERATOR", sequenceName="SEQUENCE_USERID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERS_ID_GENERATOR")
	private int id;

	@Column(name="CREATE_DATE")
	private Date createDate;

	@Column(name="DEVICE_ID")
	private String deviceId;

	@Column(name="EMAIL_ID")
	private String emailId;

	@Column(name="LASTLOGIN_DATE")
	private Date lastloginDate;

	@Column(name="LASTUPDATE_DATE")
	private Date lastupdateDate;

	private BigDecimal logincount;

	private String mobile;

	private String password;

	private String userrole;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDeviceId() {
		return this.deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Date getLastloginDate() {
		return this.lastloginDate;
	}

	public void setLastloginDate(Date lastloginDate) {
		this.lastloginDate = lastloginDate;
	}

	public Date getLastupdateDate() {
		return this.lastupdateDate;
	}

	public void setLastupdateDate(Date lastupdateDate) {
		this.lastupdateDate = lastupdateDate;
	}

	public BigDecimal getLogincount() {
		return this.logincount;
	}

	public void setLogincount(BigDecimal logincount) {
		this.logincount = logincount;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserrole() {
		return this.userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}

}