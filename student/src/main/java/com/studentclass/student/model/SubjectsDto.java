package com.studentclass.student.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
//@NoArgsConstructor
@Data
public class SubjectsDto {
    private Integer subjectId;
    private String subjectName;
}
