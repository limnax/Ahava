package com.studentclass.classes.Clients;

import com.studentclass.classes.model.SubjectsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient("subject-service")
public interface SubjectsClient {
     @GetMapping("/subjects/{studentId}")
     List<SubjectsDto> getSubjectsForStudent(@PathVariable("studentId") Integer studentId);
}
