package com.studentclass.classes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
//@NoArgsConstructor
@Data
public class SubjectsDto {
    private Integer subjectId;
    private String subjectName;
}
