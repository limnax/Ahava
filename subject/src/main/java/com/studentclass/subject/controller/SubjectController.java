package com.studentclass.subject.controller;

import com.studentclass.subject.model.Subject;
import com.studentclass.subject.model.SubjectDto;
import com.studentclass.subject.service.SubjectService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/subjects")
public class SubjectController {
    @Autowired
    private final SubjectService subjectService;

    @PostMapping
    public void addSubjects(@RequestBody Subject subjectDto){
        subjectService.addSubjects(subjectDto);
    }
    @GetMapping
    public List<Subject> getAllSubjects(){
        return subjectService.getAllSubjects();
    }
//    @GetMapping("/{id}")
//    public Subject getSubjectById(@PathVariable Integer subId){
//        return subjectService.getSubjectById(subId);
//    }
    @GetMapping("/{student-id}")
    public List<SubjectDto> getAllSubjectsForStudent(@PathVariable("student-id") Integer studentId){
        return subjectService.getAllSubjectsForStudent(studentId);
    }

}
