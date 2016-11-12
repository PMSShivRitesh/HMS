package com.airwire.hms.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.airwire.hms.util.EmploymentType;
import com.airwire.hms.util.SEX;
import com.airwire.hms.util.UserStatus;

@Entity(name="EMPLOYEE")  
public class Employee implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1354743845492515784L;

	@Column(name="EMPLOYEE_ID", columnDefinition = "CHAR(36)")
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid", strategy="uuid2")
	@Id
	private String employeeId;
	
	@Column(name = "LOGIN_NAME", nullable=false, unique=true)
	private String loginName;

	@Column(name = "PASSWORD", nullable=false, unique=true)
	private String password;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="AGE")
	private int age;
	
	@JoinColumn(name="ROLE_ID")
	@ManyToOne()
	private Role role;
	
	@Column(name="SEX")
	@Enumerated(EnumType.STRING)
	private SEX sex;
	
	@Column(name="UID")
	private String uid;
	
	@Column(name="EMAIL_ID")
	private String emailId;
	
	@Column(name="STREET_ADDRESS")
	private String streetAddress;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE")
	private String state;
	
	@Column(name="COUNTRY")
	private String country;
	
	@Column(name="CONTACT_NO")
	private String contactNo;
	
	@Column(name="CREATED_ON")
	private Date createdOn;
	
	@Column(name="MODIFIED_ON")
	private Date modifiedOn;
	
	@Column(name="DOJ")
	private Date doj;
	
	@Column(name="EMPLOYEE_STATUS")
	@Enumerated(EnumType.STRING)
	private UserStatus employeeStatus;

	@Column(name="EMPLOYMENT_TYPE")
	@Enumerated(EnumType.STRING)
	private EmploymentType employmentType;
	
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public SEX getSex() {
		return sex;
	}

	public void setSex(SEX sex) {
		this.sex = sex;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public EmploymentType getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(EmploymentType employmentType) {
		this.employmentType = employmentType;
	}

	public UserStatus getEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(UserStatus employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}