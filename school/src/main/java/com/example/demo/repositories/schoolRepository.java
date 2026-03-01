package com.example.demo.repositories;

import com.example.demo.models.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface schoolRepository extends JpaRepository<School, Integer> {

}
