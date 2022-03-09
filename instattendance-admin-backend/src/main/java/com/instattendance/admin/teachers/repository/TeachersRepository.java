package com.instattendance.admin.teachers.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.instattendance.admin.teachers.entity.Teachers;

public interface TeachersRepository extends JpaRepository<Teachers, String>{
	
	@Query(value="select * from teachers t where t.email = ?1 and t.password = ?2",nativeQuery = true)
	Teachers getTeacherByEmailAndPassword(String email , String password);

}
