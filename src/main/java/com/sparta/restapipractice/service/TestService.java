package com.sparta.restapipractice.service;

import com.sparta.restapipractice.dto.TestRequestDto;
import com.sparta.restapipractice.dto.TestResponseDto;
import com.sparta.restapipractice.entity.Student;
import com.sparta.restapipractice.entity.SubjectType;
import com.sparta.restapipractice.entity.Test;
import com.sparta.restapipractice.repository.StudentRepository;
import com.sparta.restapipractice.repository.TestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TestService {

	private final TestRepository testRepository;
	private final StudentRepository studentRepository;

	//시험저장
	public TestResponseDto studentAddTest(Long studentId, TestRequestDto testRequestDto) {
		Student student = studentRepository.findById(studentId).orElseThrow(() ->
				new IllegalArgumentException("해당 학생은 존재하지 않습니다"));


		if (!(testRequestDto.getSubjectType().equals(SubjectType.DB) || testRequestDto.getSubjectType().equals(SubjectType.JPA))) {
			throw new IllegalArgumentException("해당 과목은 존재하지 않습니다");
		}
		Test test = new Test(student, testRequestDto);
		testRepository.save(test);
		return new TestResponseDto(test);
	}


	//학생 시험조회 조회
	public List<TestResponseDto> studentGetTests(Long studentId, SubjectType subjectName) {
		List<Test> studentTestList = testRepository.findAllByStudentId(studentId);

		if (!(subjectName.equals(SubjectType.JPA) || subjectName.equals(SubjectType.DB))) {
			throw new IllegalArgumentException("해당 과목은 존재하지 않습니다");
		}

		return studentTestList.stream()
				.map(s -> new TestResponseDto(s.getSubjectType(), s.getScore()))
				.filter(s -> s.getSubjectType().equals(subjectName))
				.toList();
	}

	public List<TestResponseDto> getTestByScoreBetween(Float firstScore, Float secondScore) {

		List<Test> testList = testRepository.findByScoreBetweenOrderByScoreDesc(firstScore, secondScore).orElseThrow(() ->
				new NullPointerException("해당 점수 사이에 있는 점수는 존재하지 않습니다."));

		return testList.stream()
				.map(s -> new TestResponseDto(s.getSubjectType(), s.getScore()))
				.toList();
	}
}
