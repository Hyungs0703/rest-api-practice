package com.sparta.restapipractice.controller;

import com.sparta.restapipractice.dto.StudentRequestDto;
import com.sparta.restapipractice.dto.StudentResponseDto;
import com.sparta.restapipractice.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	//학생 등록.
	@PostMapping
	public ResponseEntity<?> addStudent(@RequestBody StudentRequestDto studentRequestDto) {
		studentService.addStudent(studentRequestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body("학생 등록이 완료되었습니다.");
	}

	//학생 id로 조회
	//(GET) /students/{id}
	@GetMapping("/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable Long id) {
		StudentResponseDto studentResponseDto = studentService.getStudentById(id);
		return ResponseEntity.status(HttpStatus.OK).body(studentResponseDto);
	}

	//학번과 이메일로 학생을 조회한다.
	//(GET) /students?number=20240614
	//첫번째 성으로 학생들을 조회한다.
	//(GET) /students?firstName=김
	@GetMapping
	public ResponseEntity<?> getStudent(
			@RequestParam(value = "studentNumber", required = false) String studentNumber,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "firstName", required = false) String firstName) {

		if (firstName == null) {
			StudentResponseDto studentResponseDto = studentService.getStudent(studentNumber, email);

			return ResponseEntity.status(HttpStatus.OK).body(studentResponseDto);
		} else {
			List<StudentResponseDto> studentResponseDto = studentService.getStudentNameList(firstName);
			return ResponseEntity.status(HttpStatus.OK).body(studentResponseDto);
		}
	}
}
