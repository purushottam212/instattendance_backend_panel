package com.instattendance.admin.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
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
