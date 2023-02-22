package com.online_gaming_service.gaming_service_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
}
