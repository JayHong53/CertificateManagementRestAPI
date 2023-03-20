package com.jiwoong.comp303.models;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="testcentre")
public class TestCentre {
	
	@Id
	@Column(name="testcentrecode")
	@Pattern(regexp = "CTRE-\\d{6}", message = "Invalid Test Centre Code")
	@GeneratedValue(generator = "CustomIdGenerator")
    @GenericGenerator(name = "CustomIdGenerator", strategy = "com.jiwoong.comp303.util.CustomIdGenerator")
	private String testCentreCode;
	
	@Column(name="centrename")
	@NotBlank(message="Test centre name cannot be blank")
	private String centreName;
	
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
	
	@Column(name="website")
	private String website;
	
	// Constructors  
	public TestCentre() {
		super();
	}

	public TestCentre(@Pattern(regexp = "CTRE-\\d{6}", message = "Invalid Test Centre Code") String testCentreCode,
			@NotBlank(message = "Test centre name cannot be blank") String centreName,
			@NotBlank(message = "Street address cannot be blank") String street,
			@NotBlank(message = "City cannot be blank") String city,
			@NotBlank(message = "Province cannot be blank") String province,
			@NotBlank(message = "Phone number cannot be blank") @Pattern(regexp = "\\d{3}-\\d{3}-\\d{4}", message = "Phone number must be in the format XXX-XXX-XXXX") String phone,
			String website) {
		super();
		this.testCentreCode = testCentreCode;
		this.centreName = centreName;
		this.street = street;
		this.city = city;
		this.province = province;
		this.phone = phone;
		this.website = website;
	}

	// Getters and Setters 
	public String getTestCentreCode() {
		return testCentreCode;
	}

	public void setTestCentreCode(String testCentreCode) {
		this.testCentreCode = testCentreCode;
	}

	public String getCentreName() {
		return centreName;
	}

	public void setCentreName(String centreName) {
		this.centreName = centreName;
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

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}	
}
