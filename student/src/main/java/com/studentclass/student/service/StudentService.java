package com.studentclass.student.service;

import com.studentclass.student.client.SubjectClient;
import com.studentclass.student.model.Student;
import com.studentclass.student.model.StudentDto;
import com.studentclass.student.model.SubjectsDto;
import com.studentclass.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
//@Builder
public class StudentService {
    @Autowired
    private final StudentRepository studentRepository;
    @Autowired
    private SubjectClient subjectClient;

    public void addStudentdetails(Student student){
        studentRepository.save(student);
    }
    public StudentDto getStudentAllDetails(Integer studentId){
        Optional<Student> student = studentRepository.findById(studentId);

        StudentDto studentDto = StudentDto.builder()
                .studId(student.get().getStudId())
                .firstname(student.get().getFirstname())
                .lastname(student.get().getLastname())
                .subjects(getTheSubjectsDetails(student.get().getStudId()))
                .build();
        return studentDto;
    }
    public List<SubjectsDto> getTheSubjectsDetails(Integer studentId){
        List<SubjectsDto> subjectsList = subjectClient.getAllSubjectsForStudent(studentId);
        return subjectsList;
    }
}
