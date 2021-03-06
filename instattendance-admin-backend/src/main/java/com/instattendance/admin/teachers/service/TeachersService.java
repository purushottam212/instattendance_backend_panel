package com.instattendance.admin.teachers.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instattendance.admin.dto.AssignRolesDto;
import com.instattendance.admin.dto.AuthenticateTeacherDto;
import com.instattendance.admin.teachers.entity.Teachers;
import com.instattendance.admin.teachers.repository.TeachersRepository;
import com.instattendance.admin.teachers.roles.entity.Roles;
import com.instattendance.admin.teachers.roles.repository.RolesRepository;

@Service
public class TeachersService {

	@Autowired
	TeachersRepository teachersRepository;
	@Autowired
	RolesRepository rolesRepository;
	public Teachers addTeacher(Teachers teacher) {
		
	
		return teachersRepository.save(teacher);
	}
	
	public Teachers getTeacherByEmail(String email ) {
		return teachersRepository.findById(email).get();
	}
	
	public List<Teachers> getAllTeachers(){
		return teachersRepository.findAll();
	}
	
	public String deleteTeacher(String email) {
		if(email!=null) {
	   teachersRepository.deleteById(email);
	   return "deleted successfully";
	   }
		return "Error ";
	}
	
	public Teachers authenticateTeacher(AuthenticateTeacherDto login) {
		Teachers teacher = teachersRepository.getTeacherByEmailAndPassword(login.getTeacherEmail(),login.getTeacherPassword());
		if(teacher == null) {
			return null;
		}
		return teacher;
	}
	
	public Teachers assignRoles(AssignRolesDto roleInfo) {
		
	   if(roleInfo != null) {
		   Roles role = rolesRepository.findById(roleInfo.getRoleId()).get();
		   Teachers teacher = teachersRepository.findById(roleInfo.getTeacherEmail()).get();
		   if(teacher != null && role != null) {
			   Teachers t1 = new Teachers();
			   t1.setEmail(teacher.getEmail());
			   t1.setName(teacher.getName());
			   t1.setPassword(teacher.getPassword());
			   t1.setDesignation(teacher.getDesignation());
			  Set<Roles> rolesSet = new HashSet<Roles>();
			  rolesSet.addAll(teacher.getRoles());
			  rolesSet.add(role);
			  t1.setRoles(rolesSet);
			   
			   
			   //role.getTeachers().add(teacher);
			   
			   return teachersRepository.save(t1);
		   }
		   return null;
	   }
	   return null;
	}
}
