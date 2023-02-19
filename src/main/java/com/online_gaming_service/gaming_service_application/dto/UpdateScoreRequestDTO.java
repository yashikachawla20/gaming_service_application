package com.online_gaming_service.gaming_service_application.dto;

public class UpdateScoreRequestDTO {
	private long userId;
	private long currentScore;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getCurrentScore() {
		return currentScore;
	}
	public void setCurrentScore(long currentScore) {
		this.currentScore = currentScore;
	}
	
	
}
