package com.instattendance.admin.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instattendance.admin.admin.entity.Admin;
import com.instattendance.admin.admin.repository.AdminRepository;
import com.instattendance.admin.dto.AdminCredintials;
import com.instattendance.admin.error_handling.ErrorHandling;
@Service


public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	public Admin createAdmin(Admin admin) {
		
		return adminRepository.save(admin);
		
	}
	
	public Admin authenticateAdmin(AdminCredintials credintials) {
		Admin admin = adminRepository.getAdminByEmailAndPassword(credintials.getEmail(), credintials.getPassword());
		
			return admin;
	
	}
	
	public ErrorHandling deleteAdmin(String email) {
		if(email != null) {
			try {
				adminRepository.deleteById(email);
				return new ErrorHandling("admin deleted", 200);	
			}
			catch(Exception e) {
				return new ErrorHandling(e.toString(), 404);
			}
			
		}
		return new ErrorHandling("Enter Email");
	}

}
