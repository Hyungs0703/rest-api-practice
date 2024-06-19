package com.sparta.restapipractice.dto;

import com.sparta.restapipractice.entity.SubjectType;
import com.sparta.restapipractice.entity.Test;
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

    public TestResponseDto(Test test) {
        this.subjectType = String.valueOf(test.getSubjectType());
        this.score = test.getScore();
    }

}
