package com.sparta.restapipractice.service;

import com.sparta.restapipractice.dto.CheckTestRequestDto;
import com.sparta.restapipractice.dto.TestRequestDto;
import com.sparta.restapipractice.dto.TestResponseDto;
import com.sparta.restapipractice.entity.Student;
import com.sparta.restapipractice.entity.SubjectType;
import com.sparta.restapipractice.entity.Test;
import com.sparta.restapipractice.repository.StudentRepository;
import com.sparta.restapipractice.repository.TestRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {

    private final TestRepository testRepository;
    private final StudentRepository studentRepository;

    public TestService(TestRepository testRepository, StudentRepository studentRepository) {
        this.testRepository = testRepository;
        this.studentRepository = studentRepository;
    }


    //시험저장
    public void addTest(TestRequestDto testRequestDto) {
        Student student = studentRepository.findById(testRequestDto.getStudentId()).orElseThrow(() ->
            new IllegalArgumentException("해당 학생은 존재하지 않습니다"));


        SubjectType subjectType1 = SubjectType.JPA;
        SubjectType subjectType2 = SubjectType.DB;

        if (!(testRequestDto.getSubjectType().equals(subjectType1.getType()) || !testRequestDto.getSubjectType().equals(subjectType2.getType()))) {
            throw new IllegalArgumentException("해당 과목은 존재하지 않습니다");
        }

        testRepository.save(new Test(testRequestDto, student));
    }

    //과목 타입 조회
    public List<Test> getTests (CheckTestRequestDto requestDto) {
        Student student = studentRepository.findById(requestDto.getStudentId()).orElseThrow(() ->
                new IllegalArgumentException("해당 학생은 존재하지 않습니다"));

        List<Test> testList = student.getTestList();
        if (testList == null) {
            return new ArrayList<>();
        }
        return testList;

    }
    //시험 조회
}
