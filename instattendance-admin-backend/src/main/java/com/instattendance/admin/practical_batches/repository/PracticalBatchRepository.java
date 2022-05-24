package com.instattendance.admin.practical_batches.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.instattendance.admin.practical_batches.entity.PracticalBatch;

public interface PracticalBatchRepository  extends JpaRepository<PracticalBatch, Integer>{

	@Query(value = "select * from batches b where b.class_name = ?1 and b.division = ?2",nativeQuery = true)
	public List<PracticalBatch>getBatchesByClassAndDiv(String className , String divName);
}
