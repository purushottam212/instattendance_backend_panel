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
public class AttendanceBetweenDatesDto {
	
	private Date startDate;
	private Date endDate;
   private String className; 
   private String divName;
   private String subject;


}
