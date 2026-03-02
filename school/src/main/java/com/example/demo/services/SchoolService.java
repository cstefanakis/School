package com.example.demo.services;

import com.example.demo.dtos.FullSchoolResponse;
import com.example.demo.models.School;

import java.util.List;

public interface SchoolService {

    void saveSchool(School school);
    List<School> getAllSchools();

    FullSchoolResponse getSchoolsWithStudents(Integer schoolId);
}
