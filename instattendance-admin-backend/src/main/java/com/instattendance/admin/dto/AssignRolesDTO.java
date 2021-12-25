package com.instattendance.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AssignRolesDTO {
	
	private String teacherEmail;
	private Integer roleId;

}
