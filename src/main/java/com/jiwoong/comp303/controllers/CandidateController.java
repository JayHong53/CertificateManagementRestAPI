package com.jiwoong.comp303.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jiwoong.comp303.models.Candidate;
import com.jiwoong.comp303.services.CandidateService;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
	
	@Autowired
	private CandidateService candidateService;
	
	// Get All
	@GetMapping("/all")
	public Iterable<Candidate> getAllCandidates() throws Exception {
		return candidateService.getAllCandidates();
	}
	
	// Get By Id
	@GetMapping("/{candidateId}")
	public Candidate getCandidate(@PathVariable String candidateId) throws Exception {
		return candidateService.getCandidate(candidateId);
	}
	
	// Create 
	@PostMapping("/add")
	public Candidate addCandidate (@Validated @RequestBody Candidate candidate) throws Exception {
		return candidateService.addCandidate(candidate);
	}
	
	// Update
	// Create 
	@PutMapping("/update")
	public Candidate updateCandidate (@Validated @RequestBody Candidate candidate) throws Exception {
		return candidateService.updateCandidate(candidate);	
	}
	
	// Delete
	@DeleteMapping("/{candidateId}")
	public String deleteCandidate (@PathVariable String candidateId) throws Exception {
		candidateService.deleteCandidate(candidateId);
	    return "Candidate with id " + candidateId + " has been deleted.";
	}
}
