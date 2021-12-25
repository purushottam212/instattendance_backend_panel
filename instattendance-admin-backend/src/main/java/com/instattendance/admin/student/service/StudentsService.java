package com.instattendance.admin.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instattendance.admin.common.entity.Classes;
import com.instattendance.admin.common.entity.Divisions;
import com.instattendance.admin.common.repository.ClassesRepository;
import com.instattendance.admin.common.repository.DivisionsRepository;
import com.instattendance.admin.dto.GetClassAndDivisionOfStudent;
import com.instattendance.admin.dto.StudentsByClassAndDivision;
import com.instattendance.admin.student.entity.Students;
import com.instattendance.admin.student.repository.StudentsRepository;

@Service
public class StudentsService {
	@Autowired
	private StudentsRepository studentsRepository;
	
	@Autowired
	private ClassesRepository classesRepository;
	@Autowired
	private DivisionsRepository divisionsRepository;
	
	public Students addStudents(Students student) {
		 Classes findClass =    classesRepository.findByClassName(student.getStudentClass().getClassName()); 
		 System.out.println("loggin00");
		 Divisions findDivision = divisionsRepository.findByDivisionName(student.getStudentDivision().getDivisionName());
		 System.out.println("loggin234");
         if(findClass != null && findDivision != null ) {
        	 System.out.println("loggin");
        	student.getStudentClass().setClassName(findClass.getClassName());
        	 System.out.println("loggin1");
        	student.getStudentClass().setId(findClass.getId());
        	 System.out.println("loggin2");
        	student.getStudentClass().getStudents().add(student);
        	 System.out.println("loggin3");
        	student.getStudentDivision().setId(findDivision.getId());
        	 System.out.println("loggin4");
        	student.getStudentDivision().setDivisionName(findDivision.getDivisionName());
        	 System.out.println("loggin5");
        	
         student.getStudentDivision().getStudents().add(student);
        	 System.out.println("loggin6");
        	 return studentsRepository.save(student);	
         }		 
		return null;	
	}
	
	public List<Students> getAllStudents(){
		return studentsRepository.findAll();
	}
	
	public Students getStudentByPrn(String prnNo) {		
		return studentsRepository.findById(prnNo).get();
	}
	
	public String deleteStudent(String prnNo) {
		if(prnNo != null) {
		 studentsRepository.deleteById(prnNo);
		 return "deleted Successfully";
		}
		return "null";
	}
	
	public Students updateStudents(Students student) {
		System.out.println(student.getStudentClass().getClassName());
		Students stud = studentsRepository.findById(student.getRollNo()).get();
		studentsRepository.delete(stud);
		Students s1 = new Students();
		s1.setName(student.getName());
		s1.setRollNo(student.getRollNo());
		s1.setPrnNo(student.getPrnNo());
		s1.setStudentClass(student.getStudentClass());
		s1.getStudentClass().setId(student.getStudentClass().getId());
		s1.getStudentClass().setStudents(student.getStudentClass().getStudents());
		
		s1.setStudentDivision(student.getStudentDivision());
		s1.getStudentDivision().setId(student.getStudentDivision().getId());
		s1.getStudentDivision().setStudents(student.getStudentDivision().getStudents());
		
	    
		Students tempStud = studentsRepository.save(s1);
		
		return tempStud;
    	
	}
	
	public List<Students> getStudentsByClassAndDivision(StudentsByClassAndDivision classAndDivision){
		return studentsRepository.getStudentsByClassAndDivision(classAndDivision);
	}
	
	public String getStudentClassAndDivision(String roll_no) {
		     
		return studentsRepository.getStudentClassAndAdivision(roll_no);
	} 
	

}
