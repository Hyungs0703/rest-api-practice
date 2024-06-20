package com.sparta.restapipractice.dto;

import com.sparta.restapipractice.entity.SubjectType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TestRequestDto {
	private Float score;
	private SubjectType subjectType;
}
