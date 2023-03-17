package com.jiwoong.comp303.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jiwoong.comp303.models.TestCentre;

public interface TestCentreRepository extends JpaRepository<TestCentre, String> {
	TestCentre findByTestCentreCode(String testCentreCode);
}
