package com.instattendance.admin.teachers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.instattendance.admin.teachers.entity.Teachers;

public interface TeachersRepository extends JpaRepository<Teachers, String>{

}
