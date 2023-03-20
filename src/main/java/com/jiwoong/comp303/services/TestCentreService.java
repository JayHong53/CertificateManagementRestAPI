package com.jiwoong.comp303.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiwoong.comp303.models.TestCentre;
import com.jiwoong.comp303.repositories.TestCentreRepository;

@Service
public class TestCentreService {

	@Autowired
	private TestCentreRepository centreRepo;

	// Get All TestCentre
	public Iterable<TestCentre> getAllTestCentres() {
		return centreRepo.findAll();
	}

	// Get a TestCentre by ID
	public TestCentre getTestCentreByCode(String testCentreCode) throws Exception {
		if (centreRepo.existsById(testCentreCode)) {
			return centreRepo.findByTestCentreCode(testCentreCode);
		} else {
			throw new Exception("TestCentre with ID " + testCentreCode + " not found");
		}
	}

	// Add a TestCentre
	public TestCentre addTestCentre(TestCentre testCentre) throws Exception {
		return centreRepo.save(testCentre);

	}

	// Update a TestCentre
	public TestCentre updateTestCentre(TestCentre testCentre) throws Exception {
		if (centreRepo.existsById(testCentre.getTestCentreCode())) {
			return centreRepo.save(testCentre);
		} else {
			throw new Exception("TestCentre with ID " + testCentre.getTestCentreCode() + " not found");
		}
	}

	// Delete a TestCentre
	public void deleteTestCentre(String testCentreCode) throws Exception {
		if (centreRepo.existsById(testCentreCode)) {
			centreRepo.deleteById(testCentreCode);
		} else {
			throw new Exception("TestCentre with ID " + testCentreCode + " not found");
		}
	}
}
