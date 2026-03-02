package com.example.demo.services;

import com.example.demo.clients.StudentClient;
import com.example.demo.dtos.FullSchoolResponse;
import com.example.demo.models.School;
import com.example.demo.repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService{

    private final SchoolRepository schoolRepository;
    private final StudentClient client;

    @Autowired
    public SchoolServiceImpl(SchoolRepository schoolRepository, StudentClient client) {
        this.schoolRepository = schoolRepository;
        this.client = client;
    }

    @Override
    public void saveSchool(School school) {
        schoolRepository.save(school);
    }

    @Override
    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    @Override
    public FullSchoolResponse getSchoolsWithStudents(Integer schoolId) {
        var school = schoolRepository.findById(schoolId)
                .orElse(School.builder()
                        .name("NOT_FOUND")
                        .email("NOT_FOUND")
                        .build());
        var students = client.findAllStudentsBySchool(schoolId);
        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
