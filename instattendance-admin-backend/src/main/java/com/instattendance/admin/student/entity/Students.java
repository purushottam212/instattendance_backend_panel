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
import com.fasterxml.jackson.annotation.JsonView;
import com.instattendance.admin.common.entity.Classes;
import com.instattendance.admin.common.entity.Divisions;
import com.instattendance.admin.fiterFields.StudentsFieldFilter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
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
	
	@JsonBackReference(value="class-students")
	@ManyToOne(fetch = FetchType.LAZY)
	//@Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "class_id")
	private Classes studentClass;
	
     @JsonBackReference(value="div_students")
	@ManyToOne(fetch = FetchType.LAZY)
    //@Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "div_id")
	private Divisions studentDivision;
	
	
	
}
