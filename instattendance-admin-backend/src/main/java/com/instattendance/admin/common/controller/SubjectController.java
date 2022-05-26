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

import com.instattendance.admin.common.entity.Subjects;
import com.instattendance.admin.common.service.SubjectsService;

@RestController
@CrossOrigin
public class SubjectController {

	@Autowired
	SubjectsService subjectsService;
	
	@PostMapping("/subjects")
	public Subjects addSubject(@RequestBody Subjects subject) {
		return subjectsService.addSubject(subject);
	}
	
	@GetMapping("/subjects/{id}")
	public Subjects getSubjectById(@PathVariable Integer id) {
		return subjectsService.getSubjectById(id);
	}
	
	@GetMapping("/subjects")
	public List<Subjects> getAllSubjects(){
		return subjectsService.getAllSubjects();
	}
	
	@DeleteMapping("/subjects/{id}")
	public String deleteSubject(@PathVariable Integer id) {
		String res = subjectsService.deleteSubjects(id);
		return res;
	}
	
	@GetMapping("/subjects/class/{className}")
	public List<Subjects> getSubjectsByClass(@PathVariable String className){
		return subjectsService.getSubjectsByClass(className);
	}
	@GetMapping("/subjects/practical/{className}")
	public List<Subjects> getPracticalsByClass(@PathVariable String className){
		return subjectsService.getPracticalsByClassId(className);
	}
	
	@GetMapping("/subjects/all/{className}")
	public List<Subjects> getAllSubjectsByClass(@PathVariable String className){
		return subjectsService.getAllSubjectsByClass(className);
	}
 }
