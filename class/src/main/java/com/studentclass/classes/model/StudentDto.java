package com.studentclass.classes.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class StudentDto {
    private Integer studId;
    private String firstname;
    private String lastname;
    private Integer classId;
    private List<SubjectsDto> subjects;
}
