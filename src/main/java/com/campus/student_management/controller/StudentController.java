package com.campus.student_management.controller;

import com.campus.student_management.entity.Student;
import com.campus.student_management.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {

        this.studentService = studentService;
    }

    // GET ALL STUDENTS
    @GetMapping
    public List<Student> getAllStudents() {

        return studentService.getAllStudents();
    }

    // CREATE STUDENT
    @PostMapping
    public Student createStudent(
            @RequestBody Student student) {

        return studentService.createStudent(student);
    }
}