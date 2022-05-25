package com.instattendance.admin.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instattendance.admin.common.entity.Attendance;
import com.instattendance.admin.common.repository.AttendanceRepository;
import com.instattendance.admin.dto.AttendanceBetweenDatesDto;
import com.instattendance.admin.dto.AttendanceDto;

@Service
public class AttendanceService {

	@Autowired
	AttendanceRepository attendanceRepository;
	
	public Attendance addAttendance(Attendance attendance) {
          return attendanceRepository.save(attendance);		
	}
	
	public Attendance getAttendanceById(Integer id) {
		return attendanceRepository.findById(id).get();
	}
	
	public Attendance getAttendanceByDateClassDivSub(AttendanceDto attendanceInformation) {
		return attendanceRepository.getAttendanceByDateClassDivSubject(attendanceInformation);
	}
	
	public List<Attendance> getAttendanceByTeacherName( String name){
		return attendanceRepository.getAttendanceByTeacherName(name);
	}
	
	public List<Attendance> getAttendanceBetweenDatesByClassAndDivision( AttendanceBetweenDatesDto attendance){
		return attendanceRepository.getAttendanceBetweenDatesByClassAndDiv(attendance);
	}
	
	public List<Attendance> getAttendanceBetweenDatesByClassDivisionAndSub( AttendanceBetweenDatesDto attendance){
		return attendanceRepository.getAttendanceBetweenDatesByClassDivAndSubj(attendance);
	}
	
	public String deleteAttendance(Integer id) {
		if(id != null) {
			attendanceRepository.deleteById(id);
			return"deleted successfully";
		}
		
		return "Error";
			
	}
	
	public List<Attendance>getAttendanceByClassSubDiv(AttendanceDto attendanceInformation){
		return attendanceRepository.getAttendanceByClassDivSubject(attendanceInformation);
	}
	
	public List<Attendance>getAttendanceByClassDivSubBatch(AttendanceDto attendance){
		
		return attendanceRepository.getAttendanceByClassDivSubBAtch(attendance.getClassName(), attendance.getDivisionName(), attendance.getSubjectName(), attendance.getBatchName());
	}
		
	
	
}
