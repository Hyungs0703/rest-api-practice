package com.sparta.restapipractice.service;

import com.sparta.restapipractice.dto.StudentRequestDto;
import com.sparta.restapipractice.dto.StudentResponseDto;
import com.sparta.restapipractice.entity.Student;
import com.sparta.restapipractice.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //학생정보 저장
    public void addStudent(StudentRequestDto studentRequestDto) {
        studentRepository.save(new Student(studentRequestDto));
    }

    //학생 정보 조회
    public StudentResponseDto getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 학생은 존재하지 않습니다"));

        return new StudentResponseDto(student);
    }
}
