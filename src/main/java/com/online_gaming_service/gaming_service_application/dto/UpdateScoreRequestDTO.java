package com.online_gaming_service.gaming_service_application.dto;

public class UpdateScoreRequestDTO {

	private Long userId;

	private Long currentScore;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCurrentScore() {
		return currentScore;
	}

	public void setCurrentScore(Long currentScore) {
		this.currentScore = currentScore;
	}
}
