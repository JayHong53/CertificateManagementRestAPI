package com.jiwoong.comp303.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiwoong.comp303.models.Candidate;
import com.jiwoong.comp303.repositories.CandidateRepository;

@Service
public class CandidateService {
	
	@Autowired
	private CandidateRepository candidateRepo;
	
	
	// Get All Candidates
	public Iterable<Candidate> getAllCandidates() {
		return candidateRepo.findAll();
	}
	
	// Get a Candidate by ID 
	public Candidate getCandidate(String id) throws Exception {
		if (candidateRepo.existsById(id)) {
			return candidateRepo.findByCandidateId(id);
		} else {
			throw new Exception("Candidate data not found");
		}
	}
	
	// Add a Candidate 
	public Candidate addCandidate(Candidate candidate) throws Exception {
		return candidateRepo.save(candidate);
	}
	
	// Update a Candidate 
	public Candidate updateCandidate(Candidate candidate) throws Exception {
		if (candidateRepo.existsById(candidate.getCandidateId())) {
			return candidateRepo.save(candidate);
		} 
		else {
			throw new Exception("Candidate data not found");
		}
	}
	
	// Delete a Candidate 
	public void deleteCandidate(String candidateId) throws Exception {
		if (candidateRepo.existsById(candidateId)) {
			candidateRepo.deleteById(candidateId);
		} else {
			throw new Exception("Candidate data not found");
		}
	}

}
