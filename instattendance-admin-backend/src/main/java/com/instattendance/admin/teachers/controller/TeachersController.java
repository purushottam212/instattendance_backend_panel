package com.instattendance.admin.teachers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.instattendance.admin.dto.AssignRolesDTO;
import com.instattendance.admin.dto.AuthenticateTeacherDTO;
import com.instattendance.admin.teachers.entity.Teachers;
import com.instattendance.admin.teachers.service.TeachersService;

@RestController
public class TeachersController {
    @Autowired
	TeachersService teachersService;
    
    @PostMapping("/teachers")
    public Teachers addTeacher(@RequestBody Teachers teacher) {
    	return teachersService.addTeacher(teacher);
    }
    
    @GetMapping("/teachers/{email}")
    public Teachers getTeacherByEmail(@PathVariable String email) {
    	return teachersService.getTeacherByEmail(email);
    }
    
    @GetMapping("/teachers")
    public List<Teachers> getAllTeachers(){
    	return teachersService.getAllTeachers();
    }
    
    @DeleteMapping("/teachers/{email}")
    public String deleteTeacher(@PathVariable String email) {
    	return  teachersService.deleteTeacher(email);
    }
    @PostMapping("/teachers/authenticate")
    public Teachers authenticateTeacher(@RequestBody @Validated AuthenticateTeacherDTO login) {
    	return teachersService.authenticateTeacher(login);
    }
    @PostMapping("/teachers/assignroles")
    public Teachers assignRoles(@RequestBody @Validated AssignRolesDTO roleInfo) {
    	return teachersService.assignRoles(roleInfo);
    }
    
}
