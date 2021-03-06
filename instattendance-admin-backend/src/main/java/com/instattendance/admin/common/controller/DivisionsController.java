package com.instattendance.admin.common.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.instattendance.admin.common.entity.Divisions;
import com.instattendance.admin.common.service.DivisionsService;
import com.instattendance.admin.fiterFields.DivisionsFieldFilter;

@RestController
@CrossOrigin
public class DivisionsController {

	@Autowired
	DivisionsService divisionsService;
	
	@PostMapping("/divisions")
	@JsonView(DivisionsFieldFilter.Base.class)
	public Divisions addDivision(@RequestBody Divisions div) {
		return divisionsService.addDivision(div);
	}
	
	@GetMapping("/divisions/{id}")
	@JsonView(DivisionsFieldFilter.Base.class)
	public Divisions getDivisionsById(@PathVariable Integer id) {
		return divisionsService.getDivisionById(id);
	}
	
	@GetMapping("/divisions")
	@JsonView(DivisionsFieldFilter.Base.class)
	public List<Divisions> getAllDivisions(){
		return divisionsService.getAllDivisions();
	}
	
	@GetMapping("/findDivisionByName/{divName}")
	public Divisions findDivisionByName(@PathVariable String divName) {
		return divisionsService.findDivisionByName(divName);
	}
	
	@DeleteMapping("/division/{id}")
	public String deleteDivision(@PathVariable Integer id) {
		return divisionsService.deleteDivision(id);
	}
}
