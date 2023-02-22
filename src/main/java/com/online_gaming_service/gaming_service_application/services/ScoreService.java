package com.online_gaming_service.gaming_service_application.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.online_gaming_service.gaming_service_application.dto.LeaderboardResponseDTO;
import com.online_gaming_service.gaming_service_application.entities.Score;
import com.online_gaming_service.gaming_service_application.entities.User;
import com.online_gaming_service.gaming_service_application.repositories.ScoreRepository;
import com.online_gaming_service.gaming_service_application.repositories.UserRepository;

@Service
public class ScoreService {

	@Autowired
	private RedisTemplate redisTemplate;

	@Autowired
	private ScoreRepository scoreRepository;

//	@Autowired
//	private UserScoreMapping userScoreMapping;

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

//	@SuppressWarnings("unchecked")
//	public List<LeaderboardResponseDTO> getTopScorersLeaderboard(long numberOfContestansts) {
//
//		// Fetch the leaderboard details from Redis Sorted Set where
//		Set<String> set = redisTemplate.opsForZSet().reverseRangeWithScores(TABLE_KEY, 0, numberOfContestansts - 1);
//
//		// To Fetch all the players in the leaderboard from Redis Sorted Set
//		// redisTemplate.opsForZSet().reverseRangeWithScores(TABLE_KEY, 0, -1);
//
//		List<LeaderboardResponseDTO> ansList = userScoreMapping.mapScoreWithUserName(set);
//		return ansList;
//	}

}
