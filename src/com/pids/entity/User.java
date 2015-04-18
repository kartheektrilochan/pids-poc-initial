package com.pids.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.pids.utils.PidsQueries;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static com.pids.utils.PidsQueries.*;

/**
 * The persistent class for the USERS database table.
 * 
 */
@Entity
@Table(name="USERS")
@NamedQueries({
			@NamedQuery(name=USERS_FINDALL, query=USERS_FINDBYDEVICEID_Q),
			@NamedQuery(name=USER_FINDBYDEVICEID, query=USERS_FINDBYDEVICEID_Q)
			})
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USERS_ID_GENERATOR", sequenceName="SEQUENCE_USERID",initialValue=0,allocationSize=0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERS_ID_GENERATOR")
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATE_DATE")
	private Date createDate;

	@Column(name="DEVICE_ID")
	private String deviceId;

	@Column(name="EMAIL_ID")
	private String emailId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LASTLOGIN_DATE")
	private Date lastloginDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LASTUPDATE_DATE")
	private Date lastupdateDate;

	private BigDecimal logincount;

	private String mobile;

	private String password;

	private String userrole;

	//bi-directional many-to-one association to AddressDetail
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	private List<AddressDetail> addressDetails;

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

	public List<AddressDetail> getAddressDetails() {
		return this.addressDetails;
	}

	public void setAddressDetails(List<AddressDetail> addressDetails) {
		this.addressDetails = addressDetails;
	}

	public AddressDetail addAddressDetail(AddressDetail addressDetail) {
		getAddressDetails().add(addressDetail);
		addressDetail.setUser(this);

		return addressDetail;
	}

	public AddressDetail removeAddressDetail(AddressDetail addressDetail) {
		getAddressDetails().remove(addressDetail);
		addressDetail.setUser(null);

		return addressDetail;
	}


}