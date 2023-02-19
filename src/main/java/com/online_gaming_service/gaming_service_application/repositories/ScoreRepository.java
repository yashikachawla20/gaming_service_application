package com.online_gaming_service.gaming_service_application.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online_gaming_service.gaming_service_application.entities.Score;
import com.online_gaming_service.gaming_service_application.entities.User;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long>{

	Score save(Score score);
}
