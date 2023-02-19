package com.online_gaming_service.gaming_service_application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
		Score s =  scoreRepository.findByUserId(userId);
		if(s == null) {
			score.setUserId(userId);
			score.setTotalScore(currentScore);
		}else {
			score = s;
			score.setTotalScore(s.getTotalScore() + currentScore);
		}
		Score scoreResponse = scoreRepository.save(score);
		return scoreResponse;
	}

	public List<Score> getLeaderboardScore(long numberOfContestansts) {
		return scoreRepository.findTop5ByOrderByTotalScoreDesc();
	}


}
