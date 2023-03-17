package com.jiwoong.comp303.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiwoong.comp303.models.Certification;
import com.jiwoong.comp303.repositories.CertificationRepository;

@Service
public class CertificationService {

	@Autowired
	private CertificationRepository certificationRepo;

	// Get All Certifications
	public Iterable<Certification> getAllCertifications() {
		return certificationRepo.findAll();
	}

	// Get a Certification by ID
	public Certification getCertificationByExamCode(String certificationCode) throws Exception {
		if (certificationRepo.existsById(certificationCode)) {
			return certificationRepo.findByCertificationCode(certificationCode);
		} else {
			throw new Exception("Certification with Code " + certificationCode + " not found");
		}
	}

	// Add a Certification
	public Certification addCertification(Certification certification) throws Exception {
		return certificationRepo.save(certification);
	}

	// Update a Certification
	public Certification updateCertification(Certification certification) throws Exception {
		if (certificationRepo.existsById(certification.getCertificationCode())) {
			return certificationRepo.save(certification);
		} else {
			throw new Exception("Certification with Code " + certification.getCertificationCode() + " not found");
		}
	}

	// Delete a Certification
	public void deleteCertification(String certificationCode) throws Exception {
		if (certificationRepo.existsById(certificationCode)) {
			certificationRepo.deleteById(certificationCode);
		} else {
			throw new Exception("Certification with Code " + certificationCode + " not found");
		}
	}

}
