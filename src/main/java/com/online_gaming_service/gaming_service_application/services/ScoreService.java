package com.online_gaming_service.gaming_service_application.services;

import java.awt.geom.Area;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
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
		
	@Autowired
	private RedisTemplate redisTemplate;
		
	private static final String TABLE_KEY= "user";
	
	public Score updateScore(long userId, long currentScore) {
		Score score = new Score();		
		Double value = redisTemplate.opsForZSet().incrementScore(TABLE_KEY, userId, currentScore);
		System.out.println("value is" + value + "Key is " + TABLE_KEY);
		return score;
	}

	public List<String> getLeaderboardScore(long numberOfContestansts) {
//		return scoreRepository.findTop5ByOrderByTotalScoreDesc();
//		List<Score> list = new ArrayList<>();
//		list.add(new Score());
//		return list;
//		Set<Serializable> set = redisTemplate.opsForZSet().rangeWithScores(TABLE_KEY, 0, -1);
		Set<String> set = redisTemplate.opsForZSet().reverseRangeWithScores(TABLE_KEY, 0, -1);
		System.out.println("Set so far is" + set + "Key is " + TABLE_KEY);
		System.out.println(set.size());
		
		Iterator value11 = set.iterator();
		System.out.println("The iterator values are: ");
		ArrayList<String> hey11 = new ArrayList<>();
		while (value11.hasNext()) {
//	            System.out.println(value11.next());
	            System.out.println("lets gopoooo");
	            hey11.add(value11.next().toString());
	            System.out.println("kkk" + hey11.size());
		}
		
		List<String> hey22 = new ArrayList<>();
		for(int i=0; i<hey11.size(); i++) {
			System.out.println(hey11.get(i));
			int index1 = hey11.get(i).indexOf("[");
			int index2 = hey11.get(i).indexOf("]");
			String newString = hey11.get(i).substring(index1+1, index2);
//			Score ssssScore = new Score();
			System.out.println("JJJJJJ" + newString);
			hey22.add(newString);
		}
		return hey22;
	}
	



}
