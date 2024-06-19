package com.sparta.restapipractice.repository;

import com.sparta.restapipractice.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestRepository extends JpaRepository <Test, Long> {
    Optional<Test> findByIdOrderByAll(Long id);
}
