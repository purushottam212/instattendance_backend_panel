package com.instattendance.admin.notification.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instattendance.admin.error_handling.ErrorHandling;
import com.instattendance.admin.notification.entity.Notification;
import com.instattendance.admin.notification.repository.NotificationRepository;

@Service
public class NotificationService {
	
	@Autowired
    private	NotificationRepository notificationRepository;
	
	public Notification createNotification(Notification notification) {
		 		 
		
		return notificationRepository.save(notification);
	}
	
	public List<Notification> getAllNotification(){
		
		return notificationRepository.findAll();
	}
	
	public List<Notification> getNotificationsByTeacherEmail(String email){
		return notificationRepository.findNotificationByTeacherEmail(email);
	}
	
	public ErrorHandling deleteNotification(Integer id) {
		if(id != null) {
			try {
				notificationRepository.deleteById(id);
				return new ErrorHandling("notification deleted", 200);	
			}
			catch(Exception e) {
				return new ErrorHandling(e.toString(), 404);
			}
			
		}
		return new ErrorHandling("select notification to delete");
	}

}
	
	
	


