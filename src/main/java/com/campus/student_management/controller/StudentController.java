package com.campus.student_management.controller;

import com.campus.student_management.entity.Student;
import com.campus.student_management.service.StudentService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

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

    // GET STUDENT BY ID
    @GetMapping("/{id}")
    public Student getStudentById(
            @PathVariable Long id) {

        return studentService.getStudentById(id);
    }

    // CREATE STUDENT
    @PostMapping
    public Student createStudent(
            @RequestBody @Valid Student student) {

        return studentService.createStudent(student);
    }

    // UPDATE STUDENT
    @PutMapping("/{id}")
    public Student updateStudent(
            @PathVariable Long id,
            @RequestBody @Valid Student student) {

        return studentService.updateStudent(id, student);
    }

    // DELETE STUDENT
    @DeleteMapping("/{id}")
    public String deleteStudent(
            @PathVariable Long id) {

        return studentService.deleteStudent(id);
    }
}