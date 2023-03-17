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

import com.jiwoong.comp303.models.Certification;
import com.jiwoong.comp303.services.CertificationService;

@RestController
@RequestMapping("/certification")
public class CertificationController {

	@Autowired
	private CertificationService certificationService;
	
	// Get All
	@GetMapping("/all")
	public Iterable<Certification> getAllCertification() throws Exception {
		return certificationService.getAllCertifications();
	}
	
	// Get By Id
	@GetMapping("/{examCode}")
	public Certification getCertification(@PathVariable String examCode) throws Exception {
		return certificationService.getCertificationByExamCode(examCode);
	}
	
	// Create 
	@PostMapping("/add")
	public Certification addCertification (@Validated @RequestBody Certification certification) throws Exception {
		return certificationService.addCertification(certification);
	}
	
	// Update
	// Create 
	@PutMapping("/update")
	public Certification updateCertification (@Validated @RequestBody Certification certification) throws Exception {
		return certificationService.updateCertification(certification);		
	}
	
	// Delete
	@DeleteMapping("/{examCode}")
	public String deleteCertification (@PathVariable String examCode) throws Exception {
		certificationService.deleteCertification(examCode);
	    return "Certification with exam code " + examCode + " has been deleted.";
	}
}
