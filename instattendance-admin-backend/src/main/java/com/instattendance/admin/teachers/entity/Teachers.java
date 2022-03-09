package com.instattendance.admin.teachers.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.instattendance.admin.fiterFields.TeachersFieldFilter;
import com.instattendance.admin.teachers.roles.entity.Roles;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="teachers")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="email")
public class Teachers {

	

	@Id
	@JsonView(TeachersFieldFilter.Base.class)
	private String email;
	@JsonView(TeachersFieldFilter.Base.class)
	private String password;
	@JsonView(TeachersFieldFilter.Base.class)
	private String name;
	@JsonView(TeachersFieldFilter.Base.class)
	private String designation;
	
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name="teacher_roles",
	      joinColumns = {@JoinColumn(name="teacher_id")},
	      inverseJoinColumns = {@JoinColumn(name="role_id")})
	private Set<Roles> roles = new HashSet<Roles>();
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	
	//@JsonManagedReference
	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}
	
}
