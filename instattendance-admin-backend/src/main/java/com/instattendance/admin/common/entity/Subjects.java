package com.instattendance.admin.common.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "subjects")
public class Subjects {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer subjectId;
	private String name;
	
	@Column(name="is_practical")
	private Boolean isPractical;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	private Classes className;
	
	
	public Integer getSubjectId() {
		return subjectId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Classes getClassName() {
		return className;
	}
	public void setClassName(Classes className) {
		this.className = className;
	}
	
	public Boolean isPractical() {
		return isPractical;
	}
	
	public void setPractical(Boolean isPractical) {
		this.isPractical = isPractical;
	}

}
