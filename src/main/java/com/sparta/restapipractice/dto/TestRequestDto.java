package com.sparta.restapipractice.dto;

import com.sparta.restapipractice.entity.SubjectType;
import lombok.Getter;

@Getter
public class TestRequestDto {
    private Float score;
    private SubjectType subjectType;
}
