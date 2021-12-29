package com.takehome.assignment.coursemanagementservice.service;

import com.takehome.assignment.coursemanagementservice.model.Course;
import com.takehome.assignment.coursemanagementservice.model.Student;
import com.takehome.assignment.coursemanagementservice.repository.CourseRepository;
import com.takehome.assignment.coursemanagementservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    public void createCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    public Course getCourse(String id) {
        Course course = courseRepository.findById(id).get();
        return course;
    }

    public List<Course> getAllCourses() {
        List<Course> courseList = courseRepository.findAll();
        return courseList;
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }

    public List<Student> getStudentList(String courseId) {
        List<Student> studentList = courseRepository.getById(courseId).getStudents();
        return studentList;
    }

    public void registerStudent(String courseId, String studentId) {
        System.out.println("ids are" + courseId + studentId);
        Course course = courseRepository.getById(courseId);
        System.out.println(course.toString());
        System.out.println(studentRepository.getById(studentId).toString());
        course.getStudents().add(studentRepository.getById(studentId));
        courseRepository.save(course);
    }

    public void deRegisterStudent(String courseId, String studentId) {
        Course course = courseRepository.getById(courseId);
        course.getStudents().remove(studentRepository.getById(studentId));
        courseRepository.save(course);
    }
}
