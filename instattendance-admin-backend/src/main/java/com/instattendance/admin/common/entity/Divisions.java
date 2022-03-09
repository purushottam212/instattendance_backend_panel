package com.instattendance.admin.common.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.instattendance.admin.fiterFields.DivisionsFieldFilter;
import com.instattendance.admin.student.entity.Students;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="divisions")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="div_id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Divisions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(DivisionsFieldFilter.Base.class)
	private Integer div_id;
	
	@Column(name="division")
	@JsonView(DivisionsFieldFilter.Base.class)
	private String divisionName;
	
	//@JsonManagedReference
	@OneToMany(mappedBy = "studentDivision",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Students> students = new HashSet<Students>();
	
	
	public Integer getId() {
		return div_id;
	}
	public void setId(Integer id) {
		this.div_id = id;
	}
	public String getDivisionName() {
		return divisionName;
	}
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}
	//@JsonManagedReference
	public Set<Students> getStudents() {
		return students;
	}
	public void setStudents(Set<Students> students) {
		this.students = students;
	}

}
