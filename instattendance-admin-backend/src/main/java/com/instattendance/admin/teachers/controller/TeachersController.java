package com.instattendance.admin.teachers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.instattendance.admin.dto.AssignRolesDto;
import com.instattendance.admin.dto.AuthenticateTeacherDto;
import com.instattendance.admin.fiterFields.TeachersFieldFilter;
import com.instattendance.admin.teachers.entity.Teachers;
import com.instattendance.admin.teachers.service.TeachersService;

@RestController
@CrossOrigin
public class TeachersController {
    @Autowired
	TeachersService teachersService;
    
    @PostMapping("/teachers")
    @JsonView(TeachersFieldFilter.Base.class)
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
    public Teachers authenticateTeacher(@RequestBody AuthenticateTeacherDto login) {
    	return teachersService.authenticateTeacher(login);
    }
    @PostMapping("/teachers/assignroles")
    public Teachers assignRoles(@RequestBody @Validated AssignRolesDto roleInfo) {
    	return teachersService.assignRoles(roleInfo);
    }
    
}
