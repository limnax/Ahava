package com.studentclass.classes.repository;

import com.studentclass.classes.model.Classrooms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<Classrooms, Integer> {
}
