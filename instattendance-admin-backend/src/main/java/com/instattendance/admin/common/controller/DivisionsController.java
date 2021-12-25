package com.instattendance.admin.common.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.instattendance.admin.common.entity.Divisions;
import com.instattendance.admin.common.service.DivisionsService;

@RestController
public class DivisionsController {

	@Autowired
	DivisionsService divisionsService;
	
	@PostMapping("/divisions")
	public Divisions addDivision(@RequestBody Divisions div) {
		return divisionsService.addDivision(div);
	}
	
	@GetMapping("/divisions/{id}")
	public Divisions getDivisionsById(@PathVariable Integer id) {
		return divisionsService.getDivisionById(id);
	}
	
	@GetMapping("/divisions")
	public List<Divisions> getAllDivisions(){
		return divisionsService.getAllDivisions();
	}
	@DeleteMapping("/division/{id}")
	public String deleteDivision(@PathVariable Integer id) {
		return divisionsService.deleteDivision(id);
	}
}
