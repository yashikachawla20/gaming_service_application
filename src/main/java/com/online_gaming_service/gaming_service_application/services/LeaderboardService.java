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
import com.online_gaming_service.gaming_service_application.entities.User;
import com.online_gaming_service.gaming_service_application.repositories.UserRepository;

@Service
public class LeaderboardService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RedisTemplate redisTemplate;

	private static final String TABLE_KEY = "GAME_LEADERBOARD";

	@SuppressWarnings("unchecked")
	public List<LeaderboardResponseDTO> getTopScorersLeaderboard(long numberOfContestansts) {

		// Fetch the leaderboard details from Redis Sorted Set where
		Set<String> sortedSet = redisTemplate.opsForZSet().reverseRangeWithScores(TABLE_KEY, 0,
				numberOfContestansts - 1);
		Iterator setData = sortedSet.iterator();
		List<LeaderboardResponseDTO> topScorersLeaderboardList = mapScoreWithUserName(setData);
		return topScorersLeaderboardList;
	}

	public List<LeaderboardResponseDTO> mapScoreWithUserName(Iterator setData) {
		List<LeaderboardResponseDTO> leaderboardList = new ArrayList<>();
		while (setData.hasNext()) {
			LeaderboardResponseDTO leaderboardResponseDTO = new LeaderboardResponseDTO();
			String infoValue = setData.next().toString();
			int firstIndex = infoValue.indexOf("=");
			int lastIndex = infoValue.lastIndexOf("=");
			int middleIndex = infoValue.indexOf(",");
			int middleIndex1 = infoValue.lastIndexOf("]");
			leaderboardResponseDTO
					.setTotalScoresValue(Double.parseDouble(infoValue.substring(firstIndex + 1, middleIndex)));
			Long userIdInfo = Long.parseLong(infoValue.substring(lastIndex + 1, middleIndex1));
			leaderboardResponseDTO.setUserNameInfo(fetchUserName(userIdInfo));
			leaderboardList.add(leaderboardResponseDTO);
		}
		return leaderboardList;
	}

	public String fetchUserName(Long userIdInfo) {
		Optional<User> userInfo = userRepository.findById(userIdInfo);
		String userNameValue = "NA";
		if (!userInfo.isEmpty()) {
			userNameValue = userInfo.get().getFirstName() + " " + userInfo.get().getLastName();
		}
		return userNameValue;
	}

}
