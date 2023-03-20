package com.jiwoong.comp303.models;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="certifiacation")
public class Certification {
	
	@Id
	@Column(name="certificationcode")
	@Pattern(regexp = "CERT-\\d{6}", message = "Invalid Exam Code")	
	@GeneratedValue(generator = "CustomIdGenerator")
    @GenericGenerator(name = "CustomIdGenerator", strategy = "com.jiwoong.comp303.util.CustomIdGenerator")
	private String certificationCode;

	@Column(name="certificationname")
	@NotBlank(message="Certifiaction name cannot be blank")
	private String certifiactionName;
	
	@Column(name="format")
	@NotBlank(message="Certifiaction format cannot be blank")
	private String format;
	
	@Column(name="duration")
	@NotNull(message="Exam duration cannot be null")
	@Min(value=0, message="Exam duration must be greater than 0")
	private int duration;
	
	@Column(name="numberofquestions")
	@NotNull(message="Number of questions cannot be null")
	@Min(value=0, message="Number of questions must be greater than 0")
	private int numberOfQuestions;
	
	@Column(name="passinggrade")
	@NotNull(message="Passing grade cannot be null")
	@DecimalMin(value="0", inclusive=true, message="Passing grade must be greater or equal to 0")
	@DecimalMax(value="100", inclusive=true, message="Passing grade must be less or equal to 100")
	private double passingGrade;
	
	@Column(name="fee")
	@NotNull(message="Exam fee cannot be null")
	@DecimalMin(value="0", inclusive=true, message="Passing grade must be greater or equal to 0")
	private double fee;
	
	// Constructors 
	public Certification() {
		super();
	}

	public Certification(@Pattern(regexp = "CERT-\\d{6}", message = "Invalid Exam Code") String certificationCode,
			@NotBlank(message = "Certifiaction name cannot be blank") String certifiactionName,
			@NotBlank(message = "Certifiaction format cannot be blank") String format,
			@NotNull(message = "Exam duration cannot be null") @Min(value = 0, message = "Exam duration must be greater than 0") int duration,
			@NotNull(message = "Number of questions cannot be null") @Min(value = 0, message = "Number of questions must be greater than 0") int numberOfQuestions,
			@NotNull(message = "Passing grade cannot be null") @DecimalMin(value = "0", inclusive = true, message = "Passing grade must be greater or equal to 0") @DecimalMax(value = "100", inclusive = true, message = "Passing grade must be less or equal to 100") double passingGrade,
			@NotNull(message = "Exam fee cannot be null") @DecimalMin(value = "0", inclusive = true, message = "Passing grade must be greater or equal to 0") double fee) {
		super();
		this.certificationCode = certificationCode;
		this.certifiactionName = certifiactionName;
		this.format = format;
		this.duration = duration;
		this.numberOfQuestions = numberOfQuestions;
		this.passingGrade = passingGrade;
		this.fee = fee;
	}

	// Getters and Setters 
	public String getCertificationCode() {
		return certificationCode;
	}

	public void setCertificationCode(String certificationCode) {
		this.certificationCode = certificationCode;
	}

	public String getCertifiactionName() {
		return certifiactionName;
	}

	public void setCertifiactionName(String certifiactionName) {
		this.certifiactionName = certifiactionName;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getNumberOfQuestions() {
		return numberOfQuestions;
	}

	public void setNumberOfQuestions(int numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}

	public double getPassingGrade() {
		return passingGrade;
	}

	public void setPassingGrade(double passingGrade) {
		this.passingGrade = passingGrade;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}
}
