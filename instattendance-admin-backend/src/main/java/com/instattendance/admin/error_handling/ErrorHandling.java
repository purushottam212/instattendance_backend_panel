package com.instattendance.admin.error_handling;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ErrorHandling {
	
	String msg;
	int code;
	
	public ErrorHandling(String msg){
		this.msg = msg;
	}

}
