package com.instattendance.admin.teachers.roles.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.instattendance.admin.teachers.roles.entity.Roles;
import com.instattendance.admin.teachers.roles.service.RolesService;

@RestController
public class RolesController {

	@Autowired
	RolesService rolesService;
	
	@PostMapping("/roles")
	public Roles addRole(@RequestBody Roles role) {
		return rolesService.addRole(role);
	}
	
	@GetMapping("/roles/{id}")
	public Roles getRoleById(@PathVariable Integer id) {
		return rolesService.getRolesById(id);
	}
	
	@GetMapping("/roles")
	public List<Roles> getAllRoles(){
		return rolesService.getAllRoles();
	} 
	
	@DeleteMapping ("/roles/{id}")
	public String deleteRole(@PathVariable Integer id) {
		return rolesService.deleteRoles(id);
	}
	
}
