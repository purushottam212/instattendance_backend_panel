package com.instattendance.admin.student.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.instattendance.admin.common.entity.Classes;
import com.instattendance.admin.common.entity.Divisions;
import com.instattendance.admin.fiterFields.StudentsFieldFilter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="rollNo")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Students {

	
	@Id
	@Column(name="roll_no",nullable = false,unique = true)     
	@JsonView(StudentsFieldFilter.Base.class)
	private String rollNo;
	
	@Column(name = "prn_no",nullable = false,unique = true)
	@JsonView(StudentsFieldFilter.Base.class)
	private String prnNo;
	@JsonView(StudentsFieldFilter.Base.class)
	private String name;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	//@Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "class_id")
	
	private Classes studentClass;
	
	@ManyToOne(fetch = FetchType.LAZY)
    //@Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "div_id")
	
	private Divisions studentDivision;
	
     public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getPrnNo() {
		return prnNo;
	}

	public void setPrnNo(String prnNo) {
		this.prnNo = prnNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//@JsonBackReference(value="class-students")
	public Classes getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(Classes studentClass) {
		this.studentClass = studentClass;
	}

	//@JsonBackReference(value="div_students")
	public Divisions getStudentDivision() {
		return studentDivision;
	}

	public void setStudentDivision(Divisions studentDivision) {
		this.studentDivision = studentDivision;
	}

	
	
	
	
	
}
