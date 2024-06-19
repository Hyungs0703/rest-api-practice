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


        if(testRequestDto.getSubjectType().equals(SubjectType.DB)|| testRequestDto.getSubjectType().equals(SubjectType.JPA)) {

        }

    }



    //과목 타입 조회
    public List<Test> getTests (CheckTestRequestDto requestDto) {
        Student student = studentRepository.findById(requestDto.getStudentId()).orElseThrow(() ->
                new IllegalArgumentException("해당 학생은 존재하지 않습니다"));

        List<Test> testList = student.
                getTestList()
                .stream()
                .filter( s -> s.getSubjectType().equals(requestDto.getSubjectType()))
                .toList();

        return testList;
    }

//    //학생 시험 리스트 조회
//    public TestResponseDto getStudentByIdTestList(Long studentId) {
//        //학생 존재 확인
//        Student student = studentRepository.findById(studentId).orElseThrow(() ->
//                new IllegalArgumentException("해당 학생은 존재하지 않습니다"));
//        //시험 존재 유무 확인
//        Test test = testRepository.findByIdOrderByAll(student.getId()).orElseThrow(()->
//                new IllegalArgumentException("시험 이력이 없습니다."));
//
//        List<Test> testList = new ArrayList<>();
//
//    }
    //시험 조회
}
