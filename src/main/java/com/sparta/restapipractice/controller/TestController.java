package com.sparta.restapipractice.controller;

import com.sparta.restapipractice.dto.CheckTestRequestDto;
import com.sparta.restapipractice.dto.TestRequestDto;
import com.sparta.restapipractice.dto.TestResponseDto;
import com.sparta.restapipractice.entity.Test;
import com.sparta.restapipractice.service.TestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping("/students/{studentId}")
public class TestController {

    public TestController(TestService testService) {
        this.testService = testService;
    }

    private final TestService testService;

    //저장
    @PostMapping("/test")
    public ResponseEntity<?> addTest(@PathVariable Long studentId, @RequestBody TestRequestDto testRequestDto) {
        testService.addTest(testRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("등록이 완료되었습니다");
    }

    //조회
    @GetMapping("/test")
    public ResponseEntity<?> getTests (@RequestBody CheckTestRequestDto requestDto) {
        List<Test> testList = testService.getTests(requestDto);
        return ResponseEntity.status(HttpStatus.OK).body(testList);
    }
}
