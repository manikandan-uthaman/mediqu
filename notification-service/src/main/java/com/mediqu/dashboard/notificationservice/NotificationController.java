package com.mediqu.dashboard.notificationservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mediqu.dashboard.notificationservice.entity.Notification;

@RestController
@RequestMapping(value = "/notifications")
public class NotificationController {
	
	@Autowired
	private NotificationRepository notificationRepository;
	
	@GetMapping
	private List<Notification> getNotifications(@RequestParam(name = "id", required = false) Integer notifyTo) {
		return notificationRepository.findByNotifyTo(notifyTo);
	}

}
