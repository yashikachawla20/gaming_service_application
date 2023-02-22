package com.online_gaming_service.gaming_service_application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.online_gaming_service.gaming_service_application.entities.Score;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {

	Score save(Score score);

	Score findByUserId(long userId);

	// If we need to fetch from DB
	// public List<Score> findTop5ByOrderByTotalScoreDesc();
}
