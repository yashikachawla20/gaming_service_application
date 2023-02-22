package com.online_gaming_service.gaming_service_application.dto;

public class LeaderboardResponseDTO {
	private Double totalScoresValue;
	private String userNameInfo;

	public Double getTotalScoresValue() {
		return totalScoresValue;
	}

	public LeaderboardResponseDTO() {
		super();
	}

	public LeaderboardResponseDTO(Double totalScoresValue, String userNameInfo) {
		super();
		this.totalScoresValue = totalScoresValue;
		this.userNameInfo = userNameInfo;
	}

	public void setTotalScoresValue(Double totalScoresValue) {
		this.totalScoresValue = totalScoresValue;
	}

	public String getUserNameInfo() {
		return userNameInfo;
	}

	public void setUserNameInfo(String userNameInfo) {
		this.userNameInfo = userNameInfo;
	}

}
