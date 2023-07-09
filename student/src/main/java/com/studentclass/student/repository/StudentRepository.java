package com.studentclass.student.repository;

import com.studentclass.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findStudentsByClassId(Integer classId);

}
