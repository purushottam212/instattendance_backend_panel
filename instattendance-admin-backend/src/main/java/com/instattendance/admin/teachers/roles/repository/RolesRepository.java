package com.instattendance.admin.teachers.roles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.instattendance.admin.teachers.roles.entity.Roles;

public interface RolesRepository extends JpaRepository<Roles, Integer> {
	
	 @Query(value = "select * from roles r where r.role = ?1", nativeQuery = true)
		public Roles  findByRoleName(String roleName); 

}
