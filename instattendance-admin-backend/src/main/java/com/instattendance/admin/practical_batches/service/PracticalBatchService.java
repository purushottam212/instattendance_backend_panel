package com.instattendance.admin.practical_batches.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instattendance.admin.dto.GetClassAndDivisionOfStudent;
import com.instattendance.admin.error_handling.ErrorHandling;
import com.instattendance.admin.practical_batches.entity.PracticalBatch;
import com.instattendance.admin.practical_batches.repository.PracticalBatchRepository;

@Service
public class PracticalBatchService {

	@Autowired
	 private PracticalBatchRepository practicalBatchRepository;
	
	public PracticalBatch createBatch(PracticalBatch batch) {
		
		return practicalBatchRepository.save(batch);
	}
	
	public List<PracticalBatch> getBatchesByClassAndDiv(GetClassAndDivisionOfStudent classAndDiv){
		return practicalBatchRepository.getBatchesByClassAndDiv(classAndDiv.getClassName(), classAndDiv.getDivName());
	}
	
	public ErrorHandling deleteBatch(Integer  id) {
		 if(id != null) {
			 
			 try {
				 practicalBatchRepository.deleteById(id);
				 return new ErrorHandling("batch deleted",200);	 
			 }
			 catch(Exception e) {
				 return new ErrorHandling(e.toString());
			 }
			 
			 
		 }
		 return new ErrorHandling("Not found",404);
	}
	
	
	
}
