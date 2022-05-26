package com.instattendance.admin.error_handling;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class ErrorHandling {
	
	String msg;
	int code;
	
	public ErrorHandling(String msg){
		this.msg = msg;
	}

}
