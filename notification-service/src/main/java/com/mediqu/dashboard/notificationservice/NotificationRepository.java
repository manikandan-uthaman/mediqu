package com.mediqu.dashboard.notificationservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mediqu.dashboard.notificationservice.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Integer>{
	
	List<Notification> findByNotifyTo(Integer notifyTo);

}
