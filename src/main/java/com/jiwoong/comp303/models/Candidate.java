package com.jiwoong.comp303.models;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="candidate")
public class Candidate {
	
	@Id
	@Column(name="candidateid")
	@Pattern(regexp = "CAND-\\d{6}", message = "Invalid Candidate ID")
	@GeneratedValue(generator = "CustomIdGenerator")
    @GenericGenerator(name = "CustomIdGenerator", strategy = "com.jiwoong.comp303.util.CustomIdGenerator")
	private String candidateId;
	
	@Column(name="firstname")
	@NotBlank(message="First name cannot be blank")
	private String firstName;
	
	@Column(name="lastname")
	@NotBlank(message="Last name cannot be blank")
	private String lastName;
	
	@Column(name="street")
	@NotBlank(message="Street address cannot be blank")
	private String street;
	
	@Column(name="city")
	@NotBlank(message="City cannot be blank")
	private String city;
	
	@Column(name="province")
	@NotBlank(message="Province cannot be blank")
	private String province;
	
	@Column(name="phone")
	@NotBlank(message="Phone number cannot be blank")
	@Pattern(regexp = "\\d{3}-\\d{3}-\\d{4}", message = "Phone number must be in the format XXX-XXX-XXXX")
	private String phone;
	
	@Column(name="email")
	@NotBlank(message="Email address cannot be blank")
	@Email(message="Invalid Email format")
	private String email;

	public Candidate() {
		super();
	}

	public Candidate(@Pattern(regexp = "CAND-\\d{6}", message = "Invalid Candidate ID") String candidateId,
			@NotBlank(message = "First name cannot be blank") String firstName,
			@NotBlank(message = "Last name cannot be blank") String lastName,
			@NotBlank(message = "Street address cannot be blank") String street,
			@NotBlank(message = "City cannot be blank") String city,
			@NotBlank(message = "Province cannot be blank") String province,
			@NotBlank(message = "Phone number cannot be blank") @Pattern(regexp = "\\d{3}-\\d{3}-\\d{4}", message = "Phone number must be in the format XXX-XXX-XXXX") String phone,
			@NotBlank(message = "Email address cannot be blank") @Email(message = "Invalid Email format") String email) {
		super();
		this.candidateId = candidateId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.city = city;
		this.province = province;
		this.phone = phone;
		this.email = email;
	}



	public String getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
