package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
//@NoArgsConstructor
@Data
@Builder
public class ClassroomDto {
    private Integer classId;
    private String className;
    private Integer stream;
    private List<StudentDto> students;
}
