package com.mediqu.dashboard.notificationservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "notifications")
public class Notification {
	
	@Id
	private Integer id;
	
	@Column(name = "notify_to")
	private Integer notifyTo;
	
	private String title;	
	private String description;
	
	@Column(name = "is_read")
	private String isRead;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNotifyTo() {
		return notifyTo;
	}

	public void setNotifyTo(Integer notifyTo) {
		this.notifyTo = notifyTo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsRead() {
		return isRead;
	}

	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}

}
