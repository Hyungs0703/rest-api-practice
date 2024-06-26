package com.sparta.restapipractice.dto;

import com.sparta.restapipractice.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StudentResponseDto {

	private String studentNumber;
	private String name;
	private String email;

	public StudentResponseDto(Student student) {
		this.studentNumber = student.getStudentNumber();
		this.name = student.getName();
		this.email = student.getEmail();
	}

}
