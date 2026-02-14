package com.example.backend_gym.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.backend_gym.models.Course;
import com.example.backend_gym.models.Disponibilite;
import com.example.backend_gym.services.CourseService;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.backend_gym.models.Coach;
import com.example.backend_gym.services.CoachService;
import java.util.List;

@RestController
@RequestMapping("/coaches")
public class CoachController {

    private final CourseService courseService;
    private final CoachService coachService;

    public CoachController(CourseService courseService, CoachService coachService) {
        this.courseService = courseService;
        this.coachService = coachService;
    }

    // COACH CRUD
      @PostMapping
    public Coach addCoach(@RequestBody Coach coach) {
        return coachService.addCoach(coach);
    }

    @PutMapping
    public Coach updateCoach(@RequestBody Coach coach) {
        return coachService.updateCoach(coach);
    }

    @DeleteMapping("/{coachId}")
    public void deleteCoach(@PathVariable Long coachId) {
        coachService.deleteCoach(coachId);
    }

    @GetMapping
    public List<Coach> getAllCoaches() {
        return coachService.getAllCoaches();
    }

    @GetMapping("/{coachId}")
    public Coach getCoachById(@PathVariable Long coachId) {
        return coachService.getCoachById(coachId);
    }


    // add a course
      @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course) {
        return courseService.updateCourse(course);
    }

    @DeleteMapping("/courses/{courseId}")
    public void deleteCourse(@PathVariable Long courseId) {
        courseService.deleteCourse(courseId);
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/courses/{courseId}")
    public Course getCourseById(@PathVariable Long courseId) {
        return courseService.getCourseById(courseId);
    }


}
