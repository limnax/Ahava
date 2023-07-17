package com.studentclass.student.service;

import com.studentclass.student.client.SubjectClient;
import com.studentclass.student.model.Student;
import com.studentclass.student.model.StudentDto;
import com.studentclass.student.model.SubjectsDto;
import com.studentclass.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.studentclass.Mapper.AppConfig;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
//@Builder
public class StudentService {
//    @Autowired
    private final StudentRepository studentRepository;
    @Autowired
    private SubjectClient subjectClient;
    AppConfig conf = new AppConfig();
//    private final ModelMapper mapper;

    public void addStudentdetails(Student student){
        studentRepository.save(student);
    }
    public StudentDto getStudentAllDetails(Integer studentId){
        Optional<Student> student = studentRepository.findById(studentId);
        if(student.isPresent()) {
            StudentDto studentDto = StudentDto.builder()
                    .studId(student.get().getStudId())
                    .firstname(student.get().getFirstname())
                    .lastname(student.get().getLastname())
                    .subjects(getTheSubjectsDetails(student.get().getStudId()))
                    .classId(student.get().getClassId())
                    .build();
            return studentDto;
        }else{
            return null;
        }
    }
    public List<SubjectsDto> getTheSubjectsDetails(Integer studentId){
        List<SubjectsDto> subjectsList = subjectClient.getAllSubjectsForStudent(studentId);
        return subjectsList;
    }

    public List<StudentDto> getStudentsFromAClass(Integer classId) {
        List<Student> studentList = studentRepository.findStudentsByClassId(classId);
        return studentList.stream().map(student -> mapToStudent(student)).collect(Collectors.toList());
    }

    private StudentDto mapToStudent(Student student){
        StudentDto newStudentDto = conf.modelMapper().map(student, StudentDto.class);
        return newStudentDto;
    }
}
