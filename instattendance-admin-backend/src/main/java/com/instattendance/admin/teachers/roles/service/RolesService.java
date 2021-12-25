package com.instattendance.admin.teachers.roles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instattendance.admin.teachers.roles.entity.Roles;
import com.instattendance.admin.teachers.roles.repository.RolesRepository;

@Service
public class RolesService {

	@Autowired
	RolesRepository rolesRepository;
	
	public Roles addRole(Roles role) {
		return rolesRepository.save(role);
	}
	
	public Roles getRolesById(Integer id) {
		return rolesRepository.findById(id).get();
	}
	
	public List<Roles> getAllRoles(){
		return rolesRepository.findAll();
	}
	
	public String deleteRoles(Integer id) {
		if(id != null) {
			 rolesRepository.deleteById(id);
			 return "deleted successfully";
		}
		return "Error Occured";
	}
}
