package com.campus.student_management.entity;

import jakarta.persistence.*;
import jakarta.validation.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "students1")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Name is required")
    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    @NotNull(message = "Department is required")
    private Department department;

    @Column(nullable = false)
    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 60, message = "Age must not exceed 60")
    private int age;

    // Default constructor required by JPA
    public Student() {
    }

    // Parameterized constructor
    public Student(String name, Department department, int age) {
        this.name = name;
        this.department = department;
        this.age = age;
    }

    // Getter
    public Long getId() {
        return id;
    }

    // Getter
    public String getName() {
        return name;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    // Getter
    public Department getDepartment() {
        return department;
    }

    // Setter
    public void setDepartment(Department department) {
        this.department = department;
    }

    // Getter
    public int getAge() {
        return age;
    }

    // Setter
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {

        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + (department != null ? department.getName() : null) + '\'' +
                ", age=" + age +
                '}';
    }
}