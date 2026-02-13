package com.example.backend_gym.services;

import com.example.backend_gym.models.Course;
import com.example.backend_gym.models.Disponibilite;
import com.example.backend_gym.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;

	public Course addCourse(Course course) {
		return courseRepository.save(course);
	}

	public Course updateCourse(Course course) {
		return courseRepository.save(course);
	}

	public void deleteCourse(Long courseId) {
		courseRepository.deleteById(courseId);
	}

	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}

	public Course getCourseById(Long courseId) {
		return courseRepository.findById(courseId).orElse(null);
	}

}
