package com.online_gaming_service.gaming_service_application.services;

import java.awt.geom.Area;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.online_gaming_service.gaming_service_application.entities.Score;
import com.online_gaming_service.gaming_service_application.entities.User;
import com.online_gaming_service.gaming_service_application.repositories.ScoreRepository;
import com.online_gaming_service.gaming_service_application.repositories.UserRepository;
import org.springframework.data.domain.Sort;

@Service
public class ScoreService {
	
//	@Autowired
//	ScoreRepository scoreRepository;
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	
	
	private static final String TABLE_KEY= "USERSSSSSS";
	
//	public Score updateScore(long userId, long currentScore) {
//		Score score = new Score();
//		Score s =  scoreRepository.findByUserId(userId);
//		if(s == null) {
//			score.setUserId(userId);
//			score.setTotalScore(currentScore);
//		}else {
//			score = s;
//			score.setTotalScore(s.getTotalScore() + currentScore);
//		}
//		Score scoreResponse = scoreRepository.save(score);
//		return scoreResponse;
//	}
	
	public Score updateScore(long userId, long currentScore) {
		Score score = new Score();
		redisTemplate.opsForHash().put(TABLE_KEY, userId, currentScore);
		System.out.println("Checking " + redisTemplate.opsForHash().values(TABLE_KEY) + "Keys are " + TABLE_KEY);
		return score;
	}

	public List<Score> getLeaderboardScore(long numberOfContestansts) {
//		return scoreRepository.findTop5ByOrderByTotalScoreDesc();
		List<Score> list = new ArrayList<>();
		list.add(new Score());
		return list;
	}
	
//	public Score updateScore(long userId, long currentScore) {
//		Score score = new Score();
//		String key = TABLE_KEY+userId;
////		jedis.zadd(key, );
//		redisTemplate.opsForHash().put(TABLE_KEY, userId, currentScore);
////		redisTemplate.opsForZSet().add(key, currentScore);
//		System.out.println("Checking " + redisTemplate.opsForHash().values(TABLE_KEY) + "Keys are " + KEY);
//		return score;
//	}


}
