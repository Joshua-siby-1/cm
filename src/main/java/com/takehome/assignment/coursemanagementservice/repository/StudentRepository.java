package com.takehome.assignment.coursemanagementservice.repository;

import com.takehome.assignment.coursemanagementservice.model.Student;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
}
