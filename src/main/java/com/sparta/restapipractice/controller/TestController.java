package com.sparta.restapipractice.controller;

import com.sparta.restapipractice.dto.CheckTestSubjectTypeRequestDto;
import com.sparta.restapipractice.dto.TestRequestDto;
import com.sparta.restapipractice.dto.TestResponseDto;
import com.sparta.restapipractice.service.TestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tests")
public class TestController {

	public TestController(TestService testService) {
		this.testService = testService;
	}

	private final TestService testService;

	//저장
	@PostMapping("/{studentId}")
	public ResponseEntity<?> studentAddTest(@PathVariable Long studentId, @RequestBody TestRequestDto testRequestDto) {
		TestResponseDto testResponseDto = testService.studentAddTest(studentId, testRequestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(testResponseDto);
	}


	//전체 조회
	@GetMapping("/{studentId}")
	public ResponseEntity<?> studentGetTests(@PathVariable Long studentId, @RequestBody CheckTestSubjectTypeRequestDto requestDto) {

		List<TestResponseDto> testList = testService.studentGetTests(studentId, requestDto);

		return ResponseEntity.status(HttpStatus.OK).body(testList);
	}

}
