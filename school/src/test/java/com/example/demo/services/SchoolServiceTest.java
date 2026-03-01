package com.example.demo.services;

import com.example.demo.models.School;
import com.example.demo.repositories.SchoolRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SchoolServiceTest {

    @InjectMocks
    private SchoolServiceImpl schoolService;

    @Mock
    private SchoolRepository schoolRepository;

    private School school01;
    private School savedSchool01;
    private School savedSchool02;
    private School savedSchool03;

    @BeforeEach
    void setupSchools(){
        this.school01 = School.builder()
                .name("school01")
                .email("school01@gmail.com")
                .build();
        this.savedSchool01 = School.builder()
                .id(1)
                .name("school01")
                .email("school01@gmail.com")
                .build();
        this.savedSchool02 = School.builder()
                .id(2)
                .name("school02")
                .email("school02@gmail.com")
                .build();
        this.savedSchool03 = School.builder()
                .id(3)
                .name("school03")
                .email("school03@gmail.com")
                .build();
    }

    @Test
    void saveSchool() {
        //Arrest
        when(schoolRepository.save(this.school01)).thenReturn(this.savedSchool01);
        //Act
        schoolService.saveSchool(this.school01);
        //Assert
        verify(schoolRepository, times(1)).save(this.school01);
    }

    @Test
    void getAllSchools() {
        //Arrest
        List<School> schools = List.of(savedSchool01, savedSchool02, savedSchool03);
        when(schoolRepository.findAll()).thenReturn(schools);
        //Act
        List<School> result = schoolService.getAllSchools();
        //Assert
        assertNotNull(result);
        assertTrue(result.contains(savedSchool01));
        assertTrue(result.contains(savedSchool02));
        assertTrue(result.contains(savedSchool03));
        verify(schoolRepository, times(1)).findAll();
    }
}