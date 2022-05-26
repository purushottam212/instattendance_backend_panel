package com.instattendance.admin.common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.instattendance.admin.common.entity.Subjects;

public interface SubjectsRepository extends JpaRepository<Subjects, Integer> {
	
	@Query(value="select * from subjects s where class_name_id = ?1 and is_practical=false",nativeQuery = true)
	List<Subjects> getSubjectsByClass(Integer id);
	
	@Query(value="select * from subjects s where class_name_id = ?1 and is_practical = true",nativeQuery = true)
	List<Subjects>getPracticalsByClassId(Integer id);
	
	@Query(value="select * from subjects s where class_name_id = ?1",nativeQuery = true)
	List<Subjects>getAllSubjectsByClassId(Integer id);
	

}
