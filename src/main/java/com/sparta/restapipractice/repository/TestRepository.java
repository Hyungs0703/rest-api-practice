package com.sparta.restapipractice.repository;

import com.sparta.restapipractice.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestRepository extends JpaRepository<Test, Long> {
	List<Test> findAllByStudentId(Long studentId);
}
