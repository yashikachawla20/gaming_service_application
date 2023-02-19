package com.online_gaming_service.gaming_service_application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.online_gaming_service.gaming_service_application.dto.RegisterUserRequestDTO;
import com.online_gaming_service.gaming_service_application.dto.RegisterUserResponseDTO;
import com.online_gaming_service.gaming_service_application.dto.ResponseDTO;
import com.online_gaming_service.gaming_service_application.dto.ResponseStatusCode;
import com.online_gaming_service.gaming_service_application.dto.UpdateScoreRequestDTO;
import com.online_gaming_service.gaming_service_application.dto.UpdateScoreResponseDTO;
import com.online_gaming_service.gaming_service_application.entities.Score;
import com.online_gaming_service.gaming_service_application.entities.User;
import com.online_gaming_service.gaming_service_application.services.ScoreService;
import com.online_gaming_service.gaming_service_application.services.UserService;



@RestController
public class ScoreController {

	@Autowired
	private ScoreService scoreService;
	
	// Update Score table
	@PutMapping("/update/score")
	public ResponseDTO<UpdateScoreResponseDTO> updateScore(@RequestBody UpdateScoreRequestDTO request) {
				
		Score score = scoreService.updateScore(request.getUserId(), request.getCurrentScore());
		ResponseDTO<UpdateScoreResponseDTO> response = new ResponseDTO<>();
		if (score == null) {
			response.setStatusCode(ResponseStatusCode.FAILURE);
			return response;
		}
		
		response.setStatusCode(ResponseStatusCode.SUCCESS);
		UpdateScoreResponseDTO responseDTO = new UpdateScoreResponseDTO();
		responseDTO.setUserId(score.getUserId());
		responseDTO.setUserId(score.getTotalScore());
		response.setData(responseDTO);
		return response;
	}
	
	// Get Leaderboard Table of n top Contestants
	@GetMapping("/leaderboard/score/{numberOfContestansts}")
	public List<Score> getLeaderboardScore(@PathVariable String numberOfContestansts) {
		List<Score> result = scoreService.getLeaderboardScore(Long.parseLong(numberOfContestansts));
		return result;
	}
}
