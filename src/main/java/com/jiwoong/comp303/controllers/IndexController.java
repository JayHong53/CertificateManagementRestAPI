package com.jiwoong.comp303.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	
	@GetMapping("/")
	public String getIndex() {
	    String message = "Certification Management System - Jiwoong Hong (301153138)";
		return message;
	}
}
