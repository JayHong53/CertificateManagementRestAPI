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

import com.jiwoong.comp303.models.Test;
import com.jiwoong.comp303.services.TestService;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private TestService testService;

	// Get All
	@GetMapping("/all")
	public Iterable<Test> getAllTests() throws Exception {
		return testService.getAllTests();
	}

	// Get By Id
	@GetMapping("/{testId}")
	public Test getTest(@PathVariable String testId) throws Exception {
		return testService.getTestById(testId);
	}

	// Create
	@PostMapping("/add")
	public Test addTestCentre(@Validated @RequestBody Test test) throws Exception {
		return testService.addTest(test);
	}

	// Update
	@PutMapping("/update")
	public Test updateTest(@Validated @RequestBody Test test) throws Exception {
		return testService.updateTest(test);
	}

	// Delete
	@DeleteMapping("/{testId}")
	public String deleteCertification(@PathVariable String testId) throws Exception {
		testService.deleteTest(testId);
		return "Test with code " + testId + " has been deleted.";
	}
}
