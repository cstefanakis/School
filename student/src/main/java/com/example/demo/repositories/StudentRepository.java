package com.example.demo.repositories;


import com.example.demo.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("""
            SELECT s FROM Student s
            WHERE s.schoolId = :schoolId
            """)
    List<Student> findAllByStudentId(@Param("schoolId") Integer schoolId);
}
