package com.takehome.assignment.coursemanagementservice.service;

import com.takehome.assignment.coursemanagementservice.model.Course;
import com.takehome.assignment.coursemanagementservice.model.Student;
import com.takehome.assignment.coursemanagementservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    public Student getStudent(String id) {
        Student student = studentRepository.findById(id).get();
        return student;
    }

    public List<Student> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }
    public List<Course> getCoursesByStudentId(String studentId) {
        List<Course> courseList = studentRepository.findById(studentId).get().getCourses();
        return courseList;
    }
}
