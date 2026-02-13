package com.example.backend_gym.services;

import com.example.backend_gym.models.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.backend_gym.models.Course;
import com.example.backend_gym.repositories.CourseRepository;
import com.example.backend_gym.models.Disponibilite;
import com.example.backend_gym.repositories.CoachRepositories;


import java.util.List;
import java.util.Optional;

@Service
public class CoachService {
	@Autowired
	private CoachRepositories coachRepository;

	public Coach addCoach(Coach coach) {
		return coachRepository.save(coach);
	}

	public Coach updateCoach(Coach coach) {
		return coachRepository.save(coach);
	}

	public void deleteCoach(Long coachId) {
		coachRepository.deleteById(coachId);
	}

	public List<Coach> getAllCoaches() {
		return coachRepository.findAll();
	}

	public Coach getCoachById(Long coachId) {
		return coachRepository.findById(coachId).orElse(null);
	}
}
