package com.jiwoong.comp303.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jiwoong.comp303.models.Test;

public interface TestRepository extends JpaRepository<Test, String> {
	Test findByTestId(String testId);
}
