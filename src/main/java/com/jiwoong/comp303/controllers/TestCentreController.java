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

import com.jiwoong.comp303.models.TestCentre;
import com.jiwoong.comp303.services.TestCentreService;

@RestController
@RequestMapping("/testcentre")
public class TestCentreController {
	
	@Autowired
	private TestCentreService centreService;

	// Get All
	@GetMapping("/all")
	public Iterable<TestCentre> getAllTestCentre() throws Exception {
		return centreService.getAllTestCentres();
	}

	// Get By Id
	@GetMapping("/{testCentreCode}")
	public TestCentre getTestCentre(@PathVariable String testCentreCode) throws Exception {
		return centreService.getTestCentreByCode(testCentreCode);
	}

	// Create
	@PostMapping("/add")
	public TestCentre addTestCentre(@Validated @RequestBody TestCentre testCentre) throws Exception {
		return centreService.addTestCentre(testCentre);
	}

	// Update
	@PutMapping("/update")
	public TestCentre updateTestCentre(@Validated @RequestBody TestCentre testCentre) throws Exception {
		return centreService.updateTestCentre(testCentre);
	}

	// Delete
	@DeleteMapping("/{testCentreCode}")
	public String deleteCertification(@PathVariable String testCentreCode) throws Exception {
		centreService.deleteTestCentre(testCentreCode);
		return "Test Centre with code " + testCentreCode + " has been deleted.";
	}
}
