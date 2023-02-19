package com.online_gaming_service.gaming_service_application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online_gaming_service.gaming_service_application.entities.Score;
import com.online_gaming_service.gaming_service_application.entities.User;
import com.online_gaming_service.gaming_service_application.repositories.ScoreRepository;
import com.online_gaming_service.gaming_service_application.repositories.UserRepository;

@Service
public class ScoreService {
	
	@Autowired
	ScoreRepository scoreRepository;
	
	public Score updateScore(long userId, long currentScore) {
		Score score = new Score();
		score.setUserId(userId);
		long prevScore = fetchPreviousTotalScoresOfUser(userId);
		score.setTotalScore(prevScore+currentScore);

		Score scoreResponse = scoreRepository.save(score);

		return scoreResponse;
	}
	
	public long fetchPreviousTotalScoresOfUser(long userId) {
//		Score s = scoreRepository.find
//		return s.getTotalScore();
		return 0;
	}

}
