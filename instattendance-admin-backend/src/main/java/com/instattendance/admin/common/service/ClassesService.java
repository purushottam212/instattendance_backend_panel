package com.instattendance.admin.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instattendance.admin.common.entity.Classes;
import com.instattendance.admin.common.repository.ClassesRepository;

@Service
public class ClassesService {
	@Autowired
	ClassesRepository  classesRepository;
	
	public Classes addClass(Classes c) {
		return classesRepository.save(c);
	}
	
	public Classes getClassById(Integer classId) {
		return classesRepository.findById(classId).get();
	}
	
	public List<Classes> getAllClasses(){
		return classesRepository.findAll();
	}

	public String deleteClass(Integer classid) {
		if(classid != null) {
			classesRepository.deleteById(classid);
			return "deleted class successfully";
		}
		return "Error Occured";
	}
}
