package com.studentclass.classes.controller;

import com.studentclass.classes.model.ClassroomDto;
import com.studentclass.classes.model.Classrooms;
import com.studentclass.classes.service.ServiceClass;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/classes")
@RequiredArgsConstructor
public class ClassController {
    @Autowired
    private final ServiceClass serviceClass;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addClasses(@RequestBody Classrooms classrooms){
        serviceClass.addClassRooms(classrooms);
    }

    @GetMapping("/{classId}")
    @ResponseStatus(HttpStatus.OK)
    public ClassroomDto getClassWithStudents(@PathVariable("classId") Integer classId){
        return serviceClass.getAllStudentsInAClass(classId);
    }
}
