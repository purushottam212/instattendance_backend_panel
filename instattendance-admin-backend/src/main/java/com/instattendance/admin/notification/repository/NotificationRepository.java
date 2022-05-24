package com.instattendance.admin.notification.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.instattendance.admin.notification.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {

	@Query(value="select * from notifications n where n.email = ?1 ", nativeQuery = true)
	public List<Notification> findNotificationByTeacherEmail(String email);
	
}
