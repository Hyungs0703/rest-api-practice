package com.sparta.restapipractice.repository;

import com.sparta.restapipractice.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TestRepository extends JpaRepository<Test, Long> {
	List<Test> findAllByStudentId(Long studentId);

	Optional<List<Test>> findByScoreBetweenOrderByScoreDesc(Float firstScore, Float secondScore);
}

