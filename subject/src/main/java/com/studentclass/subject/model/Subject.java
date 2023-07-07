package com.studentclass.subject.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "subjects")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer subjectId;
    private String subjectName;
    private Integer studentId;
}
