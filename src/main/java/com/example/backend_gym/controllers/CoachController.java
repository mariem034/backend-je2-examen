package com.example.backend_gym.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

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
    @PostMapping("/addCoach")
    public Coach addCoach(@RequestBody Coach coach) {
        return coachService.addCoach(coach);
    }

    @PostMapping("/updateCoach")
    public Coach updateCoach(@RequestBody Coach coach) {
        return coachService.updateCoach(coach);
    }

    @PostMapping("/deleteCoach")
    public void deleteCoach(@RequestBody Long coachId) {
        coachService.deleteCoach(coachId);
    }

    @PostMapping("/getAllCoaches")
    public List<Coach> getAllCoaches() {
        return coachService.getAllCoaches();
    }

    @PostMapping("/getCoachById")
    public Coach getCoachById(@RequestBody Long coachId) {
        return coachService.getCoachById(coachId);
    }


    // add a course
    @PostMapping("/addCourse")
    public Course addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    //update a course
    @PostMapping("/updateCourse")
    public Course updateCourse(@RequestBody Course course) {
        return courseService.updateCourse(course);
    }

    //delete a course
    @PostMapping("/deleteCourse")
    public void deleteCourse(@RequestBody Long courseId) {
        courseService.deleteCourse(courseId);
    }

    //get all courses
    @PostMapping("/getAllCourses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    //get a course by id
    @PostMapping("/getCourseById")
    public Course getCourseById(@RequestBody Long courseId) {
        return courseService.getCourseById(courseId);
    }


}
