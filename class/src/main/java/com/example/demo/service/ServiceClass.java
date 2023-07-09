package com.example.demo.service;

import com.example.demo.Clients.StudentClient;
import com.example.demo.Clients.SubjectsClient;
import com.example.demo.model.ClassroomDto;
import com.example.demo.model.Classrooms;
import com.example.demo.model.StudentDto;
import com.example.demo.model.SubjectsDto;
import com.example.demo.repository.ClassRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Builder
public class ServiceClass {
//    @Autowired
    private final ClassRepository classRepository;
//    @Autowired
    private final StudentClient studentClient;
    private final SubjectsClient subjectsClient;
    public ClassroomDto getAllStudentsInAClass(Integer classId){
        Optional<Classrooms> classroom = classRepository.findById(classId);
        ClassroomDto classroomDto = ClassroomDto.builder()
                .classId(classroom.get().getClassId())
                .className(classroom.get().getClassName())
                .stream(classroom.get().getStream())
                .students(getStudentsFromAClass(classroom.get().getClassId()))
                .build();
        return classroomDto;
    }

    public List<StudentDto> getStudentsFromAClass(Integer classId){
         List<StudentDto> students = studentClient.getAllStudentsInAClass(classId);
         for(StudentDto student: students){
            List<SubjectsDto> subjects =  subjectsClient.getSubjectsForStudent(student.getStudId());
            student.setSubjects(subjects);
         }

         return students;
    }
    public void addClassRooms(Classrooms classrooms){
        classRepository.save(classrooms);
    }
}


;;
