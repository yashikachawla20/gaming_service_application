package com.online_gaming_service.gaming_service_application.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Score {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private long userId;
	private long totalScore;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(long totalScore) {
		this.totalScore = totalScore;
	}
	public Score(Long id, long userId, long totalScore) {
		super();
		this.id = id;
		this.userId = userId;
		this.totalScore = totalScore;
	}
	public Score() {
		super();
	}	
}
