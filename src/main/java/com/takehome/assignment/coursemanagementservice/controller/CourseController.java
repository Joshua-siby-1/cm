package com.takehome.assignment.coursemanagementservice.controller;

import com.takehome.assignment.coursemanagementservice.model.Course;
import com.takehome.assignment.coursemanagementservice.model.Student;
import com.takehome.assignment.coursemanagementservice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    //create a course
    @PostMapping("/create-course")
    public void createCourse(@RequestBody Course course) {
        courseService.createCourse(course);
    }

    //update a course
    @PutMapping("/update-course")
    public void updateCourse(@RequestBody Course course) {
        courseService.updateCourse(course);
    }

    //read a course
    @GetMapping("/get-course/{id}")
    public Course getCourse(@PathVariable String id) {
        Course course = courseService.getCourse(id);
        return course;
    }

    //read all the courses
    @GetMapping("/get-all-courses")
    public List<Course> getAllCourses() {
        List<Course> courseList = courseService.getAllCourses();
        return courseList;
    }

    //delete a course
    @DeleteMapping("/remove-course/{id}")
    public void deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);
    }

    //get all students in a course using course id
    @GetMapping("/student-list-by-course/{courseId}")
    public List<Student> getStudentListOfCourse(@PathVariable String courseId) {
        return courseService.getStudentList(courseId);
    }

    //registering a student for a course
    @PostMapping("/register-student/{courseId}/{studentId}")
    public void registerStudent(@PathVariable String courseId,@PathVariable String studentId) {
        System.out.println(courseId + " sid "+ studentId);
        courseService.registerStudent(courseId,studentId);
    }

    //deregistering a student from a course
    @PostMapping("/deregister-student/{courseId}/{studentId}")
    public void deRegisterStudent(@PathVariable String courseId,@PathVariable String studentId) {
        courseService.deRegisterStudent(courseId,studentId);
    }
}
