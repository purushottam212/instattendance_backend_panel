package com.instattendance.admin.teachers.roles.entity;

import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.instattendance.admin.teachers.entity.Teachers;

import lombok.AllArgsConstructor;
//import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="roles")

public class Roles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@JsonBackReference
	public Set<Teachers> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teachers> teachers) {
		this.teachers = teachers;
	}

	@Column(name = "role")
	private String roleName;
	
	@JsonBackReference
	@ManyToMany(mappedBy = "roles")
	private Set<Teachers> teachers;

}
