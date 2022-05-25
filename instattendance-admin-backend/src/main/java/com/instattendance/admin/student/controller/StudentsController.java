package com.instattendance.admin.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.fasterxml.jackson.annotation.JsonView;
import com.instattendance.admin.dto.GetClassAndDivisionOfStudent;
import com.instattendance.admin.dto.StudentsByClassAndDivision;
import com.instattendance.admin.fiterFields.StudentsFieldFilter;
import com.instattendance.admin.student.entity.Students;
import com.instattendance.admin.student.service.StudentsService;

@RestController
@JsonView(StudentsFieldFilter.Base.class)
@CrossOrigin
public class StudentsController {
	@Autowired
	StudentsService service;

	@PostMapping("/students")
	
	public Students addStudent(@RequestBody Students student) {
		return service.addStudents(student);
	}

	@GetMapping("/students/{rollNo}")
	public Students getStudentByPrn(@PathVariable String rollNo) {
		return service.getStudentByPrn(rollNo);
	}

	@GetMapping("/students")
	public List<Students> getAllStudents() {
		return service.getAllStudents();
	}

	@DeleteMapping("/students/{rollNo}")
	public String deleteStudent(@PathVariable String rollNo) {
		String result = service.deleteStudent(rollNo);
		return result;
	}
    @PutMapping("/students")
	public Students updateStudent(@RequestBody Students student) {
   
		return service.updateStudents(student);
	}
   @PostMapping("/studentsByClassAndDiv")
    public List<Students> getStudentsByClassAndDivision(@RequestBody @Validated StudentsByClassAndDivision classAndDivision){
	   
		return service.getStudentsByClassAndDivision(classAndDivision);
    	/*List<Students> students =  service.getStudentsByClassAndDivision(classAndDivision);
    	MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(students);
    	
    	FilterProvider filter = new SimpleFilterProvider().
    			addFilter("FilterStudentsFields", SimpleBeanPropertyFilter.filterOutAllExcept("prnNo","rollNo","name"));
    	
    	mappingJacksonValue.setFilters(filter);
    	
    	return mappingJacksonValue;*/
    	
    }
   @GetMapping("/getClassAndDivision/{rollNo}")
   public  GetClassAndDivisionOfStudent  getClassAndDivision(@PathVariable String rollNo) {
	      String classAndDivision = service.getStudentClassAndDivision(rollNo);
	      String [] splitres = classAndDivision.split(",");
	       GetClassAndDivisionOfStudent classAndDiv = new GetClassAndDivisionOfStudent();
	       classAndDiv.setClassName(splitres[0]);
	       classAndDiv.setDivName(splitres[1]);
	       
	       return classAndDiv;
	     
   }
   
   @GetMapping("/students/batch/{batchName}")
   public List<Students> getStudentsByBatch(@PathVariable String batchName){
	   
	   return service.getStudentsByBatch(batchName);
   }
}