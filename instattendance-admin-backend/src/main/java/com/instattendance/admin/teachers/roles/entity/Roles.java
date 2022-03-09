package com.instattendance.admin.teachers.roles.entity;

import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.instattendance.admin.fiterFields.RolesFieldFilter;
import com.instattendance.admin.teachers.entity.Teachers;

import lombok.AllArgsConstructor;
//import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="roles")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Roles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(RolesFieldFilter.Base.class)
	private Integer id;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@JsonIgnore
	//@JsonBackReference
	public Set<Teachers> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teachers> teachers) {
		this.teachers = teachers;
	}

	@JsonView(RolesFieldFilter.Base.class)
	@Column(name = "role")
	private String roleName;
	
	
	@ManyToMany(mappedBy = "roles")
	private Set<Teachers> teachers;

}
