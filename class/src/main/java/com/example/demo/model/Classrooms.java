package com.example.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "classes")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Classrooms {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer classId;
    private String className;
    private Integer stream;
}
