package com.example.demo.repositories;

import com.example.demo.models.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    void createStudents(){
       studentRepository.save(Student.builder()
                .firstname("George")
                .lastname("Builder")
                .email("george.builder@email.com")
                .schoolId(1)
                .build());
        studentRepository.save(Student.builder()
                .firstname("Marie")
                .lastname("Horse")
                .email("marie.horse@email.com")
                .schoolId(1)
                .build());
        studentRepository.save(Student.builder()
                .firstname("Aleko")
                .lastname("Palpuri")
                .email("aleko.palpuri@email.com")
                .schoolId(2)
                .build());
    }

    @Test
    void findAllByStudentId() {
        //Arrest
        Integer school = 1;
        //Act
        List<Student> result = studentRepository.findAllByStudentId(school);
        //Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.stream().anyMatch(s-> s.getFirstname().equals("Marie")));
    }
}