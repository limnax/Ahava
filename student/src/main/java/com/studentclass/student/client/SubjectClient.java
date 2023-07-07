package com.studentclass.student.client;

import com.studentclass.student.model.SubjectsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("subject-service")
public interface SubjectClient {
    @GetMapping("/subjects/{studentId}")
    public List<SubjectsDto> getAllSubjectsForStudent(@PathVariable("studentId") Integer studentId);
}
