package com.sparta.restapipractice.dto;

import com.sparta.restapipractice.entity.SubjectType;
import lombok.Getter;

@Getter
public class CheckTestRequestDto {
    private Long studentId;
    //사용자가 선택값
    private SubjectType subjectType;
}
