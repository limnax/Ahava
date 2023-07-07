package com.studentclass.subject.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class SubjectDto {
    private Integer subjectId;
    private String subjectName;
    private Integer studentId;
}
