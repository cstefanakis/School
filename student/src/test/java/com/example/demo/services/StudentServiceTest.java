package com.example.demo.services;

import com.example.demo.models.Student;
import com.example.demo.repositories.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @InjectMocks
    private StudentServiceImpl studentService;

    @Mock
    private StudentRepository studentRepository;

    private Student student;
    private Student savedStudent;

    @BeforeEach
    void setupStudent(){
        this.student = Student.builder()
                .firstname("George")
                .lastname("Builder")
                .email("george.builder@email.com")
                .schoolId(1)
                .build();

        this.savedStudent = Student.builder()
                .id(1)
                .firstname("George")
                .lastname("Builder")
                .email("george.builder@email.com")
                .schoolId(1)
                .build();
    }

    @Test
    void saveStudent() {
        //Arrest
        when(studentRepository.save(this.student)).thenReturn(this.savedStudent);
        //Act
        studentService.saveStudent(this.student);
        //Assert
        verify(studentRepository, times(1)).save(this.student);
    }

    @Test
    void getAllStudents() {
        //arrest
        List<Student> students = List.of(this.savedStudent);
        when(studentRepository.findAll()).thenReturn(students);
        //Act
        List<Student> result = studentService.getAllStudents();
        //Assert
        assertNotNull(result);
        assertTrue(result.contains(this.savedStudent));
        verify(studentRepository, times(1)).findAll();
    }

    @Test
    void getAllStudentsBySchoolId() {
        //arrest
        Integer schoolId = this.savedStudent.getSchoolId();
        List<Student> students = List.of(this.savedStudent);
        when(studentRepository.findAllByStudentId(schoolId)).thenReturn(students);
        //Act
        List<Student> result = studentService.getAllStudentsBySchoolId(schoolId);
        //Assert
        assertNotNull(result);
        assertTrue(result.contains(this.savedStudent));
        verify(studentRepository, times(1)).findAllByStudentId(schoolId);
    }
}