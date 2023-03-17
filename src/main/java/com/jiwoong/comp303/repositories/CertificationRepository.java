package com.jiwoong.comp303.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jiwoong.comp303.models.Certification;

public interface CertificationRepository extends JpaRepository<Certification, String> {
	Certification findByCertificationCode(String examCode);
}
