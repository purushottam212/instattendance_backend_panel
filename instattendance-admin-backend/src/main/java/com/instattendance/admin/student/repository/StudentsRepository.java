package com.instattendance.admin.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.instattendance.admin.dto.GetClassAndDivisionOfStudent;
import com.instattendance.admin.dto.StudentsByClassAndDivision;
import com.instattendance.admin.student.entity.Students;

public interface StudentsRepository extends JpaRepository<Students, String> {

	@Query(value="select * from students s where s.class_id = :#{#classAndDivision.classId} and s.div_id = :#{#classAndDivision.divId}", nativeQuery = true)
	List<Students> findStudentsByClassAndDivision( @Param("classAndDivision")  StudentsByClassAndDivision classAndDivision);
	
	@Query(value="SELECT sql6460288.classes.class,sql6460288.divisions.division\r\n"
			+ "	  FROM sql6460288.students\r\n"
			+ "			 INNER JOIN sql6460288.classes ON sql6460288.classes.id = sql6460288.students.class_id\r\n"
			+ "			 INNER JOIN sql6460288.divisions ON sql6460288.divisions.id = sql6460288.students.div_id\r\n"
			+ "			 WHERE sql6460288.students.roll_no=?1",nativeQuery = true)
	String getStudentClassAndAdivision(String roll_no);

}
