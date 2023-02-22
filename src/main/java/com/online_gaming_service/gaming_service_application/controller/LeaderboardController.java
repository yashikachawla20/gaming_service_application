package com.online_gaming_service.gaming_service_application.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.online_gaming_service.gaming_service_application.dto.LeaderboardResponseDTO;
import com.online_gaming_service.gaming_service_application.services.LeaderboardService;

@RestController
public class LeaderboardController {

	@Autowired
	LeaderboardService leaderboardService;

	// Fetch All Time Top N Scorers
	@GetMapping("/leaderboard/score/{numberOfScorers}")
	public ResponseEntity<String> getTopScorersLeaderboard(@PathVariable String numberOfScorers) {
		try {
			if (numberOfScorers == null || numberOfScorers.isBlank()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("Please Provide the Number of Scorers which you want to fetch");
			}

			List<LeaderboardResponseDTO> result = leaderboardService
					.getTopScorersLeaderboard(Long.parseLong(numberOfScorers));

			if (result == null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("LeaderBoard is Empty. Please Try again later");
			}

			String responseDataString = "\n";
			for (int i = 0; i < result.size(); i++) {
				LeaderboardResponseDTO responseObj = result.get(i);
				responseDataString += "Name =  " + responseObj.getUserNameInfo() + " And Score =  "
						+ responseObj.getTotalScoresValue() + "\n";
			}

			return ResponseEntity.status(HttpStatus.OK)
					.body("Top " + numberOfScorers + " scorers on LeaderBoard are " + responseDataString);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Got exception " + e.getMessage() + " Please try again fetching the Scores Leaderboard");
		}
	}

}
