package com.instattendance.admin.practical_batches.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.instattendance.admin.dto.GetClassAndDivisionOfStudent;
import com.instattendance.admin.error_handling.ErrorHandling;
import com.instattendance.admin.practical_batches.entity.PracticalBatch;
import com.instattendance.admin.practical_batches.service.PracticalBatchService;

@RestController
@CrossOrigin
public class PracticalBatchController {

	@Autowired
	PracticalBatchService practicalBatchService;
	
	@PostMapping("/batch")
	public PracticalBatch createBatch(@RequestBody PracticalBatch batch) {
		
		return practicalBatchService.createBatch(batch);
	}
	
	@PostMapping("/batch/classDiv")
	public List<PracticalBatch> getBatchesByClassAndDiv(@RequestBody GetClassAndDivisionOfStudent classAndDiv){
		return practicalBatchService.getBatchesByClassAndDiv(classAndDiv);
	}
	
	
	@DeleteMapping("/batch/{id}")
	public ErrorHandling  deleteBatch(@PathVariable Integer id)   {
		
		return practicalBatchService.deleteBatch(id);
	}
}
