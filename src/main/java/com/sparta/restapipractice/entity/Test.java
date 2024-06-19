package com.sparta.restapipractice.entity;

import com.sparta.restapipractice.dto.TestRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Column
    private Float score;

    //무조건 EnumType.STRING 으로만!!.
    @Enumerated(value = EnumType.STRING)
    private SubjectType subjectType;

    @Column
    private LocalDateTime examData;

    public Test(Student student, Float score, SubjectType subjectType, LocalDateTime examData) {
        this.student = student;
        this.score = score;
        this.subjectType = subjectType;
        this.examData = examData;
    }

    public Test(TestRequestDto testRequestDto, Student student) {
        this.student = student;
        this.score = testRequestDto.getScore();
        this.subjectType = SubjectType.valueOf(testRequestDto.getSubjectType());
        this.examData = LocalDateTime.now();
    }


}
