package com.instattendance.admin.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.instattendance.admin.admin.entity.Admin;


public interface AdminRepository extends JpaRepository<Admin, String> {
	
	@Query(value="select * from admins a  where a.email = ?1 and a.password = ?2",nativeQuery = true)
	Admin getAdminByEmailAndPassword(String email , String password);

}
