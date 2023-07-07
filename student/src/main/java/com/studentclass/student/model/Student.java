package com.studentclass.student.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

//import javax.security.auth.Subject;
import java.util.List;

@Entity
@Table(name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer studId;
    private String firstname;
    private String lastname;
}
