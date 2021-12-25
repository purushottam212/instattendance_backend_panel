package com.instattendance.admin.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.instattendance.admin.common.entity.Divisions;

public interface DivisionsRepository extends JpaRepository<Divisions, Integer> {
	
	 @Query(value = "select * from divisions d where d.division = ?1", nativeQuery = true)
		public Divisions findByDivisionName(String divisionName);

}
