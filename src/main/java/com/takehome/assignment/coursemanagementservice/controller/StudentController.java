package com.takehome.assignment.coursemanagementservice.controller;

import com.takehome.assignment.coursemanagementservice.model.Course;
import com.takehome.assignment.coursemanagementservice.model.Student;
import com.takehome.assignment.coursemanagementservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/create-student")
    public void createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
    }

    @PutMapping("/update-student")
    public void updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
    }

    @GetMapping("/get-student/{id}")
    public Student getStudent(@PathVariable String id) {
        Student student = studentService.getStudent(id);
        return student;
    }

    @GetMapping("/get-all-students")
    public List<Student> getAllStudents() {
        List<Student> studentList = studentService.getAllStudents();
        return studentList;
    }

    @DeleteMapping("/remove-student/{id}")
    public void deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
    }

    @GetMapping("/course-list-by-student/{studentId}")
    public Set<Course> getCourseListByStudent(@PathVariable String studentId) {
        return studentService.getCoursesByStudentId(studentId);
    }
}
