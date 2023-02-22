package com.online_gaming_service.gaming_service_application.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.online_gaming_service.gaming_service_application.dto.UpdateScoreRequestDTO;
import com.online_gaming_service.gaming_service_application.entities.Score;
import com.online_gaming_service.gaming_service_application.services.ScoreService;

@RestController
public class ScoreController {

	@Autowired
	private ScoreService scoreService;

	// Update Score table
	@PostMapping("/update/score")
	public ResponseEntity<String> updateScore(@RequestBody UpdateScoreRequestDTO updateScoreRequest) {
		try {
			if (updateScoreRequest.getUserId() == null || updateScoreRequest.getCurrentScore() == null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
						"User Id and Current Score are mandatory fields to update the score of user. Please provide them.");
			}

			Score score = scoreService.updateScore(updateScoreRequest.getUserId(),
					updateScoreRequest.getCurrentScore());
			if (score == null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Score didn't get Updated. Please Try again");
			}

			return ResponseEntity.status(HttpStatus.OK).body("Scores got updated for User id  " + score.getUserId());

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Got exception " + e.getMessage() + " Please try again by giving proper Values");
		}
	}

	// Fetch All Time Top N Scorers
	@GetMapping("/leaderboard/score/{numberOfScorers}")
	public ResponseEntity<String> getTopScorersLeaderboard(@PathVariable String numberOfScorers) {
		try {
			if (numberOfScorers == null || numberOfScorers.isBlank()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("Please Provide the Number of Scorers which you want to fetch");
			}

			List<String> result = scoreService.getTopScorersLeaderboard(Long.parseLong(numberOfScorers));

			if (result == null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("LeaderBoard is Empty. Please Try again later");
			}

			return ResponseEntity.status(HttpStatus.OK)
					.body("Top " + numberOfScorers + " scorers on LeaderBoard are " + result);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Got exception " + e.getMessage() + " Please try again fetching the Scores Leaderboard");
		}
	}
}
