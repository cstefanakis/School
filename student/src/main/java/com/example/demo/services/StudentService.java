package com.example.demo.services;

import com.example.demo.models.Student;

import java.util.List;

public interface StudentService {
    void saveStudent(Student student);
    List<Student> getAllStudents();
    List<Student> getAllStudentsBySchoolId(Integer schoolId);
}
