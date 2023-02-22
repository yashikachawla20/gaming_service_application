package com.online_gaming_service.gaming_service_application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.online_gaming_service.gaming_service_application.entities.Score;
import com.online_gaming_service.gaming_service_application.repositories.ScoreRepository;

@Service
public class ScoreService {

	@Autowired
	private RedisTemplate redisTemplate;

	@Autowired
	private ScoreRepository scoreRepository;

	private static final String TABLE_KEY = "GAME_LEADERBOARD";

	@SuppressWarnings("unchecked")
	public Score updateScore(long userId, long currentScore) {
		Score newScore = new Score();
		newScore.setUserId(userId);
		newScore.setCollectedScores(currentScore);
		Score scoreResponse = scoreRepository.save(newScore);

		// Increment the scores in Redis Sorted Set
		redisTemplate.opsForZSet().incrementScore(TABLE_KEY, scoreResponse.getUserId(),
				scoreResponse.getCollectedScores());

		return scoreResponse;
	}
}
