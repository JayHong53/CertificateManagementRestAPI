package com.jiwoong.comp303.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jiwoong.comp303.models.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, String> {
	Candidate findByCandidateId(String candidateId);
}
