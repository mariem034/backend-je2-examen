package com.example.backend_gym.repositories;
import com.example.backend_gym.models.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachRepositories extends JpaRepository<Coach, Long> {
    
}
