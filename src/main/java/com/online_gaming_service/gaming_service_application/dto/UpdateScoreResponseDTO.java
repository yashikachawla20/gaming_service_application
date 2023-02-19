package com.online_gaming_service.gaming_service_application.dto;

public class UpdateScoreResponseDTO {
	
	private Long userId;
	private Long currentTotalScore;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long setCurrentTotalScore() {
		return currentTotalScore;
	}
	public void setCurrentTotalScore(Long currentScore) {
		this.currentTotalScore = currentScore;
	}
	
}
