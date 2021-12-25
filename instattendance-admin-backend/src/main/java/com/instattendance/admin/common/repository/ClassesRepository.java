package com.instattendance.admin.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.instattendance.admin.common.entity.Classes;

public interface ClassesRepository extends JpaRepository<Classes, Integer> {
	 @Query(value = "select * from classes c where c.class = ?1", nativeQuery = true)
	public Classes  findByClassName(String className); 

}
