package com.campus.student_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campus.student_management.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}