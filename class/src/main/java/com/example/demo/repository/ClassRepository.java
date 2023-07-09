package com.example.demo.repository;

import com.example.demo.model.Classrooms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<Classrooms, Integer> {
}
