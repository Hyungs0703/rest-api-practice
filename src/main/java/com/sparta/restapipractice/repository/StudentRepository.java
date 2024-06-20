package com.sparta.restapipractice.repository;

import com.sparta.restapipractice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

	Student findByStudentNumberAndEmail(String studentNumber, String email);

	Optional<List<Student>> findByNameStartsWith(String firstName);
}



