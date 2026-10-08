package com.campus.student_management.service;

import com.campus.student_management.entity.Department;
import com.campus.student_management.entity.Student;
import com.campus.student_management.repository.DepartmentRepository;
import com.campus.student_management.repository.StudentRepository;
import com.campus.student_management.exception.StudentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;

    public StudentService(
            StudentRepository studentRepository,
            DepartmentRepository departmentRepository) {

        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
    }

    // CREATE
    public Student createStudent(Student student) {

        Long departmentId = student.getDepartment().getId();

        Department department = departmentRepository
                .findById(departmentId)
                .orElseThrow(() ->
                        new RuntimeException("Department not found with ID: " + departmentId));

        student.setDepartment(department);

        return studentRepository.save(student);
    }

    // READ ALL
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // READ BY ID
    public Student getStudentById(Long id) {

        return studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException(
                                "Student not found with ID: " + id));
    }

    // UPDATE
    public Student updateStudent(Long id, Student student) {

        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException(
                                "Student not found with ID: " + id));

        Long departmentId = student.getDepartment().getId();

        Department department = departmentRepository
                .findById(departmentId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Department not found with ID: " + departmentId));

        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());
        existingStudent.setDepartment(department);

        return studentRepository.save(existingStudent);
    }

    // DELETE
    public String deleteStudent(Long id) {

        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException(
                    "Student not found with ID: " + id);
        }

        studentRepository.deleteById(id);

        return "Student deleted successfully";
    }
}