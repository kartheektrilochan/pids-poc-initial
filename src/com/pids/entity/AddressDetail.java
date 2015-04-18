package com.pids.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ADDRESS_DETAILS database table.
 * 
 */
@Entity
@Table(name="ADDRESS_DETAILS")
@NamedQuery(name="AddressDetail.findAll", query="SELECT a FROM AddressDetail a")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class AddressDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ADDRESS_DETAILS_ID_GENERATOR", sequenceName="SEQUENCE_ADDRESS_DETAILSID",initialValue=0,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ADDRESS_DETAILS_ID_GENERATOR")
	private int id;

	private String address1;

	private String address2;

	private String address3;

	private String city;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATE_DATE")
	private Date createDate;

	private String district;

	private String firstname;

	private String gender;

	private String isprimary;

	private String landmark;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LASTLOGIN_DATE")
	private Date lastloginDate;

	private String lastname;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LASTUPDATE_DATE")
	private Date lastupdateDate;

	private String middlename;

	private String mobile;

	private String pinnumber;

	@Column(name="\"STATE\"")
	private String state;

	private String status;

	//bi-directional many-to-one association to User
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="USERS_ID")
	private User user;

	public AddressDetail() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return this.address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIsprimary() {
		return this.isprimary;
	}

	public void setIsprimary(String isprimary) {
		this.isprimary = isprimary;
	}

	public String getLandmark() {
		return this.landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public Date getLastloginDate() {
		return this.lastloginDate;
	}

	public void setLastloginDate(Date lastloginDate) {
		this.lastloginDate = lastloginDate;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getLastupdateDate() {
		return this.lastupdateDate;
	}

	public void setLastupdateDate(Date lastupdateDate) {
		this.lastupdateDate = lastupdateDate;
	}

	public String getMiddlename() {
		return this.middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPinnumber() {
		return this.pinnumber;
	}

	public void setPinnumber(String pinnumber) {
		this.pinnumber = pinnumber;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}