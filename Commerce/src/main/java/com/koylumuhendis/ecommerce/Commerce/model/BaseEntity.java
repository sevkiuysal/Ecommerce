package com.koylumuhendis.ecommerce.Commerce.model;

import java.time.LocalDateTime;

public class BaseEntity {
	
	private LocalDateTime createdDateTime;
	private LocalDateTime updatedDateTime;
	public BaseEntity(LocalDateTime createdDateTime, LocalDateTime updatedDateTime) {
		this.createdDateTime = createdDateTime;
		this.updatedDateTime = updatedDateTime;
	}
	public BaseEntity() {
	}
	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}
	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}
	public LocalDateTime getUpdatedDateTime() {
		return updatedDateTime;
	}
	public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}
	
	

}
