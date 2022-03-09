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

import com.instattendance.admin.common.entity.Attendance;
import com.instattendance.admin.common.service.AttendanceService;
import com.instattendance.admin.dto.AttendanceBetweenDatesDto;
import com.instattendance.admin.dto.AttendanceDto;

@RestController
@CrossOrigin
public class AttendanceController {

	@Autowired
	AttendanceService attendanceService;
	
	@PostMapping("/attendance")
	public Attendance addAttendance(@RequestBody Attendance attendance) {
		return attendanceService.addAttendance(attendance);
	}
	
	@GetMapping("/attendance/{name}")
	public List<Attendance> getAttendanceByTeacherName(@PathVariable  String name) {
		return attendanceService.getAttendanceByTeacherName(name);
	}
	
	@PostMapping("/getAttendanceByDate")
	public Attendance getAttendanceByDate(@RequestBody AttendanceDto attendanceInfo){
		return attendanceService.getAttendanceByDateClassDivSub(attendanceInfo);
	}
	
	@PostMapping("/getAttendanceBetweenDate")
	public List<Attendance> getAttendanceBetweenDatesByClassDiv( @RequestBody AttendanceBetweenDatesDto attendance){
		return attendanceService.getAttendanceBetweenDatesByClassAndDivision(attendance);
	}
	
	@PostMapping("/getAttendanceBysubClassDivDates")
	public List<Attendance> getAttendanceBetweenDatesByClassDivSub(@RequestBody AttendanceBetweenDatesDto attendance){
		return attendanceService.getAttendanceBetweenDatesByClassDivisionAndSub(attendance);
	}
	
	@PostMapping("/getAttendanceByClassSubDiv")
	public List<Attendance> getAttendanceByClassDivSub(@RequestBody AttendanceDto attendanceInfo){
		return attendanceService.getAttendanceByClassSubDiv(attendanceInfo);
	}
	
	@DeleteMapping("/attendance/{id}")
	public String deleteAttendance(@PathVariable Integer id) {
		return attendanceService.deleteAttendance(id);
	}
}
