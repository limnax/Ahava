package com.example.demo.controller;

import com.example.demo.model.ClassroomDto;
import com.example.demo.model.Classrooms;
import com.example.demo.service.ServiceClass;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/classes")
@RequiredArgsConstructor
public class ClassController {
    @Autowired
    private final ServiceClass serviceClass;

    @PostMapping
    public void addClasses(@RequestBody Classrooms classrooms){
        serviceClass.addClassRooms(classrooms);
    }

    @GetMapping("/{classId}")
    public ClassroomDto getClassWithStudents(@PathVariable("classId") Integer classId){
        return serviceClass.getAllStudentsInAClass(classId);
    }
}
