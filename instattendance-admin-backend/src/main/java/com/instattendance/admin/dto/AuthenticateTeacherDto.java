package com.instattendance.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthenticateTeacherDto {

	private String teacherEmail;
	private String teacherPassword;
}
