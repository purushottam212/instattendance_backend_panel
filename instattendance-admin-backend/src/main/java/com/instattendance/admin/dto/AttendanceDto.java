package com.instattendance.admin.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AttendanceDto {
	
	private Date attendanceDate;
	
	private String className;
	
	private String divisionName;
	
	private String subjectName;
	
	private String batchName;
	


}
