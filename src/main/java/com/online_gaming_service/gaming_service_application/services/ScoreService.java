package com.online_gaming_service.gaming_service_application.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
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

		// Create new Scores entry in the table
		Score scoreResponse = scoreRepository.save(newScore);

		// Increment the scores in Redis Sorted Set
		redisTemplate.opsForZSet().incrementScore(TABLE_KEY, scoreResponse.getUserId(),
				scoreResponse.getCollectedScores());

		return scoreResponse;
	}

	@SuppressWarnings("unchecked")
	public List<String> getTopScorersLeaderboard(long numberOfContestansts) {

		// Fetch the leaderboard details from Redis Sorted Set where
		Set<String> set = redisTemplate.opsForZSet().reverseRangeWithScores(TABLE_KEY, 0, numberOfContestansts-1);

		// To Fetch all the players in the leaderboard from Redis Sorted Set
		// Set<String> set =
		// redisTemplate.opsForZSet().reverseRangeWithScores(TABLE_KEY, 0, -1);

		Iterator setData = set.iterator();
		ArrayList<String> listValues = new ArrayList<>();
		while (setData.hasNext()) {
			listValues.add(setData.next().toString());
		}

		List<String> leaderboardList = new ArrayList<>();
		for (int i = 0; i < listValues.size(); i++) {
			int index1 = listValues.get(i).indexOf("[");
			int index2 = listValues.get(i).indexOf("]");
			String newString = listValues.get(i).substring(index1 + 1, index2);
			leaderboardList.add(newString);
		}
		return leaderboardList;
	}

}
