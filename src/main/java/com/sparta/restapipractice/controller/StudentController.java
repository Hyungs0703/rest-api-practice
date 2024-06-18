package com.sparta.restapipractice.controller;

import com.sparta.restapipractice.dto.StudentRequestDto;
import com.sparta.restapipractice.dto.StudentResponseDto;
import com.sparta.restapipractice.repository.StudentRepository;
import com.sparta.restapipractice.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //학생 등록.
    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody StudentRequestDto studentRequestDto) {
        studentService.addStudent(studentRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("학생 등록이 완료되었습니다.");
    }

    //학생 id로 조회
    //(GET) /students/{id}
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id) {
        StudentResponseDto studentResponseDto = studentService.getStudentById(id);
        return ResponseEntity.status(HttpStatus.OK).body(studentResponseDto);
    }


//    //학생 전체조회
//    //(GET) /students
//    //(GET) /students?number=20240614
//    @GetMapping
//    public ResponseEntity<?> getStudents(
//            @RequestParam(value = "number",required = false) String studentNumber) {
//                if(StringUtils.hasLength(studentNumber)) {
//                    Student student = this.studentMap.getByNumber(studentNumber);
//                    return ResponseEntity.status(HttpStatus.OK).body(student);
//                }
//
//        List<Student> studentList = this.studentMap.getAll();
//        return ResponseEntity.status(HttpStatus.OK).body(studentList);
//    }
//
//
//    //URL로 입력받는 방법
//    //1. PathVariable(path)            -> /students/1
//    //2. RequestParam(parameter)       -> /students?number=20240614
//
//    /**
//     * @PathVariable Long stduentId, @PathVariable Long subjectId
//     *  -> /students/1/subjects/1
//     */
//
//    /**
//     * @RequestParam String studentNumber, @RequestParam String name
//     * -> /students?number=20240614/name?=chris
//     */
//
//    /**
//     *  @GetMapping("/{studentId}/subjects/{subjectId}")
//     *  public ResponseEntity<?> getStudentById(
//     *  @PathVariable Long studentId,@PathVariable Long subjectId)
//     */
//
//    /**
//     * public ResponseEntity<?> sample(
//     * @RequestParam String studentNumber,
//     * @RequestParam String name)
//     */
}
