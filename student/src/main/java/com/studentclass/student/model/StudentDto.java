package com.studentclass.student.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class StudentDto {
    private Integer studId;
    private String firstname;
    private String lastname;
    private List<SubjectsDto> subjects;
}
