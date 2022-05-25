package com.instattendance.admin.common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.instattendance.admin.common.entity.Attendance;
import com.instattendance.admin.dto.AttendanceBetweenDatesDto;
import com.instattendance.admin.dto.AttendanceDto;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {
	
	@Query(value="select * from attendance_record a where a.date = :#{#attendanceInfo.attendanceDate} and a.class=:#{#attendanceInfo.className} and a.division =:#{#attendanceInfo.divisionName} and a.subject=:#{#attendanceInfo.subjectName} ",nativeQuery = true)
   Attendance getAttendanceByDateClassDivSubject(@Param("attendanceInfo") AttendanceDto attendanceInfo);	
	
	@Query(value="select * from attendance_record a where a.faculty = ?1 ",nativeQuery = true)
	 List<Attendance> getAttendanceByTeacherName(String name);
	
	@Query(value="select * from attendance_record a where a.date BETWEEN  :#{#attendanceBetweenDates.startDate} AND  :#{#attendanceBetweenDates.endDate} AND a.class = :#{#attendanceBetweenDates.className} AND a.division=:#{#attendanceBetweenDates.divName} ",nativeQuery = true)
	 List<Attendance>getAttendanceBetweenDatesByClassAndDiv(@Param("attendanceBetweenDates") AttendanceBetweenDatesDto attendance);
	
	@Query(value="select * from attendance_record a where a.date BETWEEN  :#{#attendanceBetweenDatesBySub.startDate} AND  :#{#attendanceBetweenDatesBySub.endDate} AND a.class = :#{#attendanceBetweenDatesBySub.className} AND a.division=:#{#attendanceBetweenDatesBySub.divName} AND a.subject = :#{#attendanceBetweenDatesBySub.subject}",nativeQuery = true)
	 List<Attendance>getAttendanceBetweenDatesByClassDivAndSubj(@Param("attendanceBetweenDatesBySub") AttendanceBetweenDatesDto attendance);
	
	@Query(value="select * from attendance_record a where a.class=:#{#attendanceInfo.className} and a.division =:#{#attendanceInfo.divisionName} and a.subject=:#{#attendanceInfo.subjectName}",nativeQuery = true)
	   List<Attendance> getAttendanceByClassDivSubject(@Param("attendanceInfo") AttendanceDto attendanceInfo);	
	
	@Query(value="select * from attendance_record a where a.class = ?1 and a.division = ?2 and a.subject = ?3 and a.batch = ?4",nativeQuery = true)
	List<Attendance> getAttendanceByClassDivSubBAtch(String className, String div, String subject,String batch);
	

}
