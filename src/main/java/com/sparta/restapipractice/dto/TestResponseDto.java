package com.sparta.restapipractice.dto;

import com.sparta.restapipractice.entity.SubjectType;
import com.sparta.restapipractice.entity.Test;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TestResponseDto {
	//과목 타입
	private SubjectType subjectType;
	//시험 점수
	private Float score;

	public TestResponseDto(Test test) {
		this.subjectType = test.getSubjectType();
		this.score = test.getScore();
	}

}
