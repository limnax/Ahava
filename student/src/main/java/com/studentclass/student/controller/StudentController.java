package com.studentclass.student.controller;

import com.studentclass.student.model.Student;
import com.studentclass.student.model.StudentDto;
import com.studentclass.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private final StudentService studentService;
    @GetMapping("/{studentId}")
    public StudentDto getStudentDetails(@PathVariable(value="studentId") Integer studentId){
       return studentService.getStudentAllDetails(studentId);
    }

    @PostMapping
    public void addStudent(@RequestBody Student studentDto){

        studentService.addStudentdetails(studentDto);
    }
    @RequestMapping("/class/{classId}")
  public List<StudentDto> getAllStudentsInAClass(@PathVariable("classId") Integer classId){
        return studentService.getStudentsFromAClass(classId);
    }
}
