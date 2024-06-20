package com.sparta.restapipractice.entity;

import com.sparta.restapipractice.dto.StudentRequestDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String studentNumber;

	@Column
	private String name;

	@Email
	@Column
	private String email;

	public Student(StudentRequestDto studentRequestDto) {
		this.studentNumber = studentRequestDto.getStudentNumber();
		this.name = studentRequestDto.getName();
		this.email = studentRequestDto.getEmail();
	}
}
