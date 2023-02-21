package com.online_gaming_service.gaming_service_application.services;

import java.awt.geom.Area;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.online_gaming_service.gaming_service_application.entities.Score;
import com.online_gaming_service.gaming_service_application.entities.User;
import com.online_gaming_service.gaming_service_application.repositories.ScoreRepository;
import com.online_gaming_service.gaming_service_application.repositories.UserRepository;

import redis.clients.jedis.JedisPool;

import org.springframework.data.domain.Sort;

@Service
public class ScoreService {
	
//	@Autowired
//	ScoreRepository scoreRepository;
	
	@Autowired
	private RedisTemplate redisTemplate;
	
//	@Autowired
//	private RedisUtil util;
	
	private static final String TABLE_KEY= "SSUSER";
	
//	private JedisPool jedisPool = null;
	
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
	
//	public Score updateScore(long userId, long currentScore) {
//		Score score = new Score();
//		redisTemplate.opsForHash().put(TABLE_KEY, userId, currentScore);
//		System.out.println("Checking " + redisTemplate.opsForHash().values(TABLE_KEY) + "Keys are " + TABLE_KEY);
//		return score;
//	redisTemplate.opsForZSet().incrementScore(TABLE_KEY, currentScore, userId);
//	}

	public List<Score> getLeaderboardScore(long numberOfContestansts) {
//		return scoreRepository.findTop5ByOrderByTotalScoreDesc();
		List<Score> list = new ArrayList<>();
		list.add(new Score());
		return list;
	}
	
	public Score updateScore(long userId, long currentScore) {
		Score score = new Score();
		double data = 1222;
		String keyssString = "heedkl";
		final String groupId = new String("hhh");
		final Double dataId = new Double(1222);
//		redisTemplate.opsForZSet().add(TABLE_KEY, groupId, data);
//		redisTemplate.opsForZSet().add(TABLE_KEY, currentScore, userId);
		redisTemplate.opsForZSet().incrementScore(TABLE_KEY, currentScore, userId);
		
		int start = -1000000000;
		int end = 100000;
		
		Set<String> keys = redisTemplate.opsForZSet().range(TABLE_KEY, start, end);
		System.out.println("Checking " + keys + "Keys are " + TABLE_KEY);
		
		long ans = redisTemplate.opsForZSet().size(TABLE_KEY);
		System.out.println("Size is" + ans + "Keys are " + TABLE_KEY);
		
//		Set<Serializable> set = redisTemplate.opsForZSet().rangeByScore(TABLE_KEY, userId, userId);
		Set<Serializable> set = redisTemplate.opsForZSet().rangeWithScores(TABLE_KEY, start, end);
		System.out.println("Size isccccc" + set + "Keys are " + TABLE_KEY);
		
		return score;
	}


}
