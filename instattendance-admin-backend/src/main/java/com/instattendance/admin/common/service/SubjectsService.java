package com.instattendance.admin.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instattendance.admin.common.entity.Classes;
import com.instattendance.admin.common.entity.Subjects;
import com.instattendance.admin.common.repository.ClassesRepository;
import com.instattendance.admin.common.repository.SubjectsRepository;

@Service
public class SubjectsService {

	@Autowired
	SubjectsRepository subjectsRepository;
	@Autowired
	ClassesRepository classesRepository;
	
	public Subjects addSubject(Subjects subject) {
		Classes findClass = classesRepository.findByClassName(subject.getClassName().getClassName());
		
		if(findClass != null) {
			subject.getClassName().setId(findClass.getId());
			subject.getClassName().setClassName(subject.getClassName().getClassName());
            return subjectsRepository.save(subject)	;	
		}
		return null;
	}
	
	public Subjects getSubjectById(Integer id) {
		return subjectsRepository.findById(id).get();
	}
	
	public List<Subjects> getAllSubjects(){
		return subjectsRepository.findAll();
	}
	
	public String deleteSubjects(Integer id) {
		if(id != null) {
			subjectsRepository.deleteById(id);
			return "Subject Deleted";
		}
		
		return "Error";
	}
	
	public List<Subjects> getSubjectsByClass(String className){
		Classes findClass = classesRepository.findByClassName(className);
		
		if(findClass != null) {
			return subjectsRepository.getSubjectsByClass(findClass.getId());
		}
		
		return null;
	} 
	
	public List<Subjects>getPracticalsByClassId(String className){
		
		Classes findClass = classesRepository.findByClassName(className);
		
		if(findClass != null) {
			return subjectsRepository.getPracticalsByClassId(findClass.getId());
		}
		
		return null;
		
	}
	
	public List<Subjects> getAllSubjectsByClass(String className){
		Classes findClass = classesRepository.findByClassName(className);
		
		if(findClass != null) {
			return subjectsRepository.getAllSubjectsByClassId(findClass.getId());
		}
		
		return null;
	} 
}
