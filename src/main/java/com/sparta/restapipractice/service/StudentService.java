package com.sparta.restapipractice.service;

import com.sparta.restapipractice.dto.StudentRequestDto;
import com.sparta.restapipractice.dto.StudentResponseDto;
import com.sparta.restapipractice.entity.Student;
import com.sparta.restapipractice.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

	//학번과 이메일로 학생을 조회한다.
	public StudentResponseDto getStudent(String studentNumber, String email) {
		Student student = studentRepository.findByStudentNumberAndEmail(studentNumber, email);

		return new StudentResponseDto(student);
	}

	//첫번째 성을 가진 학생들을 조회한다.
	public List<StudentResponseDto> getStudentNameList(String firstName) {

		List<Student> studentList = studentRepository.findByNameStartsWith(firstName).orElseThrow(() ->
				new NullPointerException("해당 학생은 존재하지 않습니다"));

		return studentList.stream()
				.map(s -> new StudentResponseDto(s.getStudentNumber(), s.getName(), s.getEmail()))
				.toList();
	}


}
