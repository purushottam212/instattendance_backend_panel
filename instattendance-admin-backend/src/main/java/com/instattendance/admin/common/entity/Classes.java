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
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.instattendance.admin.student.entity.Students;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name="classes")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Classes {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="class")
	private String className;
	
	@JsonIgnore
	//@JsonManagedReference
	@OneToMany(mappedBy = "studentClass",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<Students> students = new HashSet<Students>();
	
	//@JsonManagedReference
	@OneToMany(mappedBy = "className",cascade = CascadeType.ALL)
	private Set<Subjects> subjects =  new HashSet<Subjects>();
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	//@JsonManagedReference
	public Set<Students> getStudents() {
		return students;
	}

	public void setStudents(Set<Students> students) {
		this.students = students;
	}
	//@JsonManagedReference
	public Set<Subjects> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subjects> subjects) {
		this.subjects = subjects;
	}

}
