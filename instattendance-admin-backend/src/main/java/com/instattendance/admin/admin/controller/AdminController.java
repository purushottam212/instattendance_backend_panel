package com.instattendance.admin.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.instattendance.admin.admin.entity.Admin;
import com.instattendance.admin.admin.service.AdminService;
import com.instattendance.admin.dto.AdminCredintials;
import com.instattendance.admin.error_handling.ErrorHandling;

@RestController
@CrossOrigin
public class AdminController {

	@Autowired
    AdminService adminService;
	
	@PostMapping("/admin")
	public Admin createAdmin(@RequestBody  Admin admin) {
		
		return adminService.createAdmin(admin);
	   
	   
	}	
	
	@PostMapping("/admin/authenticate")
	public Admin authenticateAdmin(@RequestBody AdminCredintials credintials) {
		return adminService.authenticateAdmin(credintials);
	}
	@DeleteMapping("/admin/{email}")
	public ErrorHandling deleteAdmin(@PathVariable  String email) {
		
		return adminService.deleteAdmin(email);
	}
		
	}
	
	
	
	

