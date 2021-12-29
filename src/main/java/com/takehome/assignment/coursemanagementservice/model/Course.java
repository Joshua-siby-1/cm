package com.takehome.assignment.coursemanagementservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {
    @Id
    @Column(name="course_id")
    private String courseId;
    private String courseName;
    private int credits;
    private String instructorName;
    @ManyToMany(fetch = FetchType.LAZY ,cascade = {CascadeType.ALL})
    @JoinTable(name="st_c",
            joinColumns={@JoinColumn(name="course_id")},
            inverseJoinColumns={@JoinColumn(name="student_id")})
    @JsonIgnore
    private List<Student> students;

    public Course() {
    }

    public Course(String courseId, String courseName, int credits, String instructorName, List<Student> students) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
        this.instructorName = instructorName;
        this.students = students;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
