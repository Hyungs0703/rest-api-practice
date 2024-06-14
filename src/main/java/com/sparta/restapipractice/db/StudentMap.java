package com.sparta.restapipractice.db;

import com.sparta.restapipractice.dto.StudentRequestDto;
import com.sparta.restapipractice.entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class StudentMap {

    private Map<Long, Student> studentMap;
    //DB대용
    public StudentMap() {
        this.studentMap = new ConcurrentHashMap<>();
    }

    //studentMap에 추가
    public void add(Long id, StudentRequestDto studentRequestDto) {
        Student student = this.converDtoToStudent(studentRequestDto);
        this.studentMap.put(id, student);
    }

    //해당 ID에 Student 가져오는 메소드
    public Student getById(Long id) {
       return this.studentMap.get(id);
    }


    public Student getByNumber(String studentNumber) {
        List<Student> studentList = this.studentMap
                                .values()
                                .stream()
                                .filter(student ->
                                        student.getStudentNumber().equals(studentNumber))
                .toList();

        return studentList.get(0);
    }
    //학생 전체조회
    public List<Student> getAll() {
        return this.studentMap.values().stream().toList();
    }

    //dto를 student로 변환
    private Student converDtoToStudent(StudentRequestDto studentRequestDto) {
        return new Student(
                studentRequestDto.getId(),
                studentRequestDto.getStudentNumber(),
                studentRequestDto.getName(),
                studentRequestDto.getEmail()
        );
    }
}
