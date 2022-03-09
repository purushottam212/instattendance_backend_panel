package com.instattendance.admin.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.instattendance.admin.common.entity.Divisions;
import com.instattendance.admin.common.repository.DivisionsRepository;

@Service
public class DivisionsService {

	@Autowired
	DivisionsRepository divisionsRepository;
	
	public Divisions addDivision(Divisions div) {
		return divisionsRepository.save(div);
	}
	
	public Divisions getDivisionById(Integer id) {
		return divisionsRepository.findById(id).get();
	}
	
	public List<Divisions> getAllDivisions(){
		return divisionsRepository.findAll(Sort.by(Sort.Direction.ASC, "divisionName"));
	}
	
	public String deleteDivision(Integer id) {
		if(id!=null) {
			divisionsRepository.deleteById(id);	
			return "Deleted Division";
		}
		return "wrong";
		 
	}
	
	public Divisions findDivisionByName(String divName) {
		return divisionsRepository.findByDivisionName(divName);
	}
}
