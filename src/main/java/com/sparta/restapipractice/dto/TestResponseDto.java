package com.sparta.restapipractice.dto;

import com.sparta.restapipractice.entity.SubjectType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TestResponseDto {
    private Long studentId;
    //과목 타입
    private String subjectType;
    //시험 점수
    private Float score;
}
