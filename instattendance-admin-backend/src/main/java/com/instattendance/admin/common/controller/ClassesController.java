package com.instattendance.admin.common.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.instattendance.admin.common.entity.Classes;
import com.instattendance.admin.common.service.ClassesService;

@RestController
@CrossOrigin
public class ClassesController {

	@Autowired
	ClassesService classesService;
	
	@PostMapping("/classes")
	public Classes addClass(@RequestBody Classes c) {
	       return classesService.addClass(c);	
	}
	
	@GetMapping("/classes/{id}")
	public Classes getClass(@PathVariable Integer id) {
		return classesService.getClassById(id);
	}
	
	@GetMapping("/classes")
	public List<Classes> getAllClasses(){
		return classesService.getAllClasses();
	}
	
	@DeleteMapping("/classes/{id}")
	public String deleteClass(@PathVariable Integer id) {
		String result = classesService.deleteClass(id);
		return result;
	}
	
	@GetMapping("/findClassByName/{className}")
	public Classes findClassByName(@PathVariable String className) {
		return classesService.findClassByName(className);
	}
	
}
