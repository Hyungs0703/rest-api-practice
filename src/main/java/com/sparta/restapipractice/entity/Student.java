package com.sparta.restapipractice.entity;

import com.sparta.restapipractice.dto.StudentRequestDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
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

    @OneToMany(mappedBy = "student")
    private List<Test> testList = new ArrayList<>();


    public Student(StudentRequestDto studentRequestDto) {
        this.studentNumber = studentRequestDto.getStudentNumber();
        this.name = studentRequestDto.getName();
        this.email = studentRequestDto.getEmail();
    }

}
