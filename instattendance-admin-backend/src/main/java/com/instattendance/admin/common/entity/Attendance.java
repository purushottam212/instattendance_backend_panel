package com.instattendance.admin.common.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="attendance_record")
public class Attendance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "date",nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date attendanceDate;
	

	
	@Column(name="time")
	private String attendanceTime;
	
	@Column(name="class")
	private String className;
	
	@Column(name="division")
	private String divisionName;
	
	private String faculty;
	
	private String subject;
	
	@Column(name="batch")
	private String batchName;
	
	@Column(name="present_students")
	private String presentStudents;
	
	@Column(name = "absent_students")
	private String absentStudents;
	
}
