package com.airwire.hms.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.airwire.hms.util.RoleType;

@Entity(name="ROLE")
public class Role implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4896661032489629142L;

	@GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name="ROLE_ID",columnDefinition = "CHAR(36)")
    @Id
	private String roleId;
	
	@Column(name="TYPE", nullable=false, unique=true)
	@Enumerated(EnumType.STRING)
	private RoleType roleType;
	
	@Column(name="CREATED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	@Column(name="MODIFIED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedOn;
	
	
	@OneToMany(mappedBy = "role", fetch=FetchType.LAZY)
	private List<Employee> employees;
	
	public String getId() {
		return roleId;
	}

	public void setId(String roleId) {
	
		this.roleId = roleId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
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

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}

}
