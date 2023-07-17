package com.studentclass.classes.Clients;

import com.studentclass.classes.model.StudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("student-service")
public interface StudentClient {
    @RequestMapping("/students/class/{classId}")
   List<StudentDto> getAllStudentsInAClass(@PathVariable("classId") Integer ClassId);
}
