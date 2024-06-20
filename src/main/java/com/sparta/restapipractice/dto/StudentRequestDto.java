package com.sparta.restapipractice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StudentRequestDto {

	private String studentNumber;

	private String name;

	private String email;
}
