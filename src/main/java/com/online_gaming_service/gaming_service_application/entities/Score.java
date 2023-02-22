package com.online_gaming_service.gaming_service_application.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "score")
public class Score implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false)
	private Long userId;

	@Column(nullable = false)
	private Long collectedScores;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCollectedScores() {
		return collectedScores;
	}

	public void setCollectedScores(Long collectedScores) {
		this.collectedScores = collectedScores;
	}

	public Score(long id, Long userId, Long collectedScores) {
		super();
		this.id = id;
		this.userId = userId;
		this.collectedScores = collectedScores;
	}

	public Score() {
		super();
	}
}
