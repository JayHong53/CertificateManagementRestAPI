package com.jiwoong.comp303.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiwoong.comp303.models.Candidate;
import com.jiwoong.comp303.models.Certification;
import com.jiwoong.comp303.models.Test;
import com.jiwoong.comp303.models.TestCentre;
import com.jiwoong.comp303.repositories.CandidateRepository;
import com.jiwoong.comp303.repositories.CertificationRepository;
import com.jiwoong.comp303.repositories.TestCentreRepository;
import com.jiwoong.comp303.repositories.TestRepository;

@Service
public class TestService {

	@Autowired
	private TestRepository testRepo;
	@Autowired
	private CandidateRepository candidateRepo;
	@Autowired
	private CertificationRepository certificationRepo;
	@Autowired
	private TestCentreRepository centreRepo;

	// Get All Tests
	public Iterable<Test> getAllTests() {
		return testRepo.findAll();
	}

	// Get a TestCentre by ID
	public Test getTestById(String testId) throws Exception {
		if (testRepo.existsById(testId)) {
			return testRepo.findByTestId(testId);
		} else {
			throw new Exception("Test with ID " + testId + " not found");
		}
	}

	// Add a Test
	public Test addTest(Test test) throws Exception {
		String candidateId = test.getCandidate().getCandidateId();
		String certificationCode = test.getCertification().getCertificationCode();
		String testCentreCode = test.getTestCentre().getTestCentreCode();

		// check if Candidate exists
		Candidate candidate = candidateRepo.findByCandidateId(candidateId);
		if (candidate != null) {
			test.setCandidate(candidate);
		} else {
			throw new Exception("Candidate with ID " + candidateId + " does not exist");
		}

		// check if Certification exists
		Certification certification = certificationRepo.findByCertificationCode(certificationCode);
		if (certification != null) {
			test.setCertification(certification);
		} else {
			throw new Exception("Certification with code " + certificationCode + " does not exist");
		}

		// check if TestCentre exists
		TestCentre testCentre = centreRepo.findByTestCentreCode(testCentreCode);
		if (testCentre != null) {
			test.setTestCentre(testCentre);
		} else {
			throw new Exception("TestCentre with code " + testCentreCode + " does not exist");
		}

		return testRepo.save(test);
	}

	// Update a Test
	public Test updateTest(Test test) throws Exception {
		if (testRepo.existsById(test.getTestId())) {
			return testRepo.save(test);
		} else {
			throw new Exception("Test with ID " + test.getTestId() + " not found");
		}
	}

	// Delete a TestCentre
	public void deleteTest(String testId) throws Exception {
		if (testRepo.existsById(testId)) {
			testRepo.deleteById(testId);
		} else {
			throw new Exception("Test with ID " + testId + " not found");
		}
	}
}
