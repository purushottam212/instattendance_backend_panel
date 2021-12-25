package com.instattendance.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class StudentsByClassAndDivision {
	
	private Integer class_id;
	private Integer div_id;

}
