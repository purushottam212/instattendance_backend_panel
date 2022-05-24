package com.instattendance.admin.notification.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.instattendance.admin.error_handling.ErrorHandling;
import com.instattendance.admin.notification.entity.Notification;
import com.instattendance.admin.notification.service.NotificationService;

@RestController
@CrossOrigin
public class NotificationController {

	@Autowired
	 private NotificationService notificationService;
	
	@PostMapping("/notification")
	public Notification createNotification(@RequestBody Notification notification) {
		return notificationService.createNotification(notification);
	}
	
	@GetMapping("/notification")
	public List<Notification> getAllNotification(){
		return notificationService.getAllNotification();
	}
	
	@GetMapping("/notification/{email}")
	public List<Notification> getNotificationByTeacherEmail(@PathVariable String email){
		return notificationService.getNotificationsByTeacherEmail(email);
	}
	@DeleteMapping("/notification/{id}")
	public ErrorHandling deleteNotification(@PathVariable Integer id) {
		return notificationService.deleteNotification(id);
	}
}
