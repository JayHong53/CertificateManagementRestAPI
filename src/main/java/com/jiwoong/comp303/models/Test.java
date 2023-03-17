package com.jiwoong.comp303.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="test")
public class Test {
	
	@Id
	@Column(name="testid")
	@Pattern(regexp = "TEST-\\d{6}", message = "Invalid Test ID")
	@GeneratedValue(generator = "CustomIdGenerator")
    @GenericGenerator(name = "CustomIdGenerator", strategy = "com.jiwoong.comp303.util.CustomIdGenerator")
	private String testId;
	
	@ManyToOne
	@JoinColumn(name="candidateid")	
	@NotNull(message="Candidate cannot be null")
	private Candidate candidate;
	
	@ManyToOne
	@JoinColumn(name="certificationcode")
	@NotNull(message="Certification cannot be null")
	private Certification certification;
	
	@ManyToOne
	@JoinColumn(name="testcentrecode")	
	@NotNull(message="TestCentre cannot be null")
	private TestCentre testCentre;	
	
	@Column(name="testdatetime")
	@NotNull(message="Test date and time cannot be null")
	private LocalDateTime testDateTime;
	
	@Column(name="score")
	@NotNull(message="Test score cannot be null")
	@DecimalMin(value="0", inclusive=true, message="Test score must be greater than or equal to 0")
	private double score;
	
	@Column(name="result")
	private String result;
	
	public Test() {
		super();
	}
	
	public Test(@Pattern(regexp = "TEST-\\d{6}", message = "Invalid Test ID") String testId,
			@NotNull(message = "Candidate cannot be null") Candidate candidate,
			@NotNull(message = "Certification cannot be null") Certification certification,
			@NotNull(message = "TestCentre cannot be null") TestCentre testCentre,
			@NotNull(message = "Test date and time cannot be null") LocalDateTime testDateTime,
			@NotNull(message = "Test score cannot be null") @DecimalMin(value = "0", inclusive = true, message = "Test score must be greater than or equal to 0") double score) {
		super();
		this.testId = testId;
		this.candidate = candidate;
		this.certification = certification;
		this.testCentre = testCentre;
		this.testDateTime = testDateTime;
		this.score = score;
		this.result = score >= certification.getPassingGrade() ? "Pass" : "Fail";
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public Certification getCertification() {
		return certification;
	}

	public void setCertification(Certification certification) {
		this.certification = certification;
	}

	public TestCentre getTestCentre() {
		return testCentre;
	}

	public void setTestCentre(TestCentre testCentre) {
		this.testCentre = testCentre;
	}

	public LocalDateTime getTestDateTime() {
		return testDateTime;
	}

	public void setTestDateTime(LocalDateTime testDateTime) {
		this.testDateTime = testDateTime;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getResult() {
		return result;
	}
	
	@PrePersist
	@PreUpdate
	private void updateResult() {
		this.result = this.score >= this.certification.getPassingGrade() ? "Pass" : "Fail";
	}
}
