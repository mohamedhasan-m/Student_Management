package com.campus.student_management.service;

import com.campus.student_management.entity.Student;
import com.campus.student_management.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }

    // CREATE
    public Student createStudent(Student student) {

        return studentRepository.save(student);
    }

    // READ ALL
    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }
}