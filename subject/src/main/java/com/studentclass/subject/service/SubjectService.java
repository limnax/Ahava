package com.studentclass.subject.service;

import com.studentclass.subject.model.Subject;
import com.studentclass.subject.model.SubjectDto;
import com.studentclass.subject.repository.SubjectRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Builder
public class SubjectService {
    @Autowired
    private final SubjectRepository subjectRepository;
    @Autowired
    private final ModelMapper mapper;


    public void addSubjects(Subject subjectDto){
        subjectRepository.save(subjectDto);
    }
    public List<Subject> getAllSubjects(){
        return  subjectRepository.findAll();
    }

    public Subject getSubjectById(Integer subjectId){
        Optional<Subject> subjectDto= subjectRepository.findById(subjectId);
        if (subjectDto.isPresent()){
            return subjectDto.get();
        }else {
            return null;
        }
    }
    public List<SubjectDto> getAllSubjectsForStudent(Integer studentId){
            List<Subject> subjects = subjectRepository.findSubjectsByStudentId(studentId);
        return subjects.stream().map(subject -> mapToDTO(subject)).collect(Collectors.toList());
    }
    private SubjectDto mapToDTO(Subject subject) {
        //convert entity to DTO
        SubjectDto newSubjectDto = mapper.map(subject, SubjectDto.class);

        return newSubjectDto;
    }
}

