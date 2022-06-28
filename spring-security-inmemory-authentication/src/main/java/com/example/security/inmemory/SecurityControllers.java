package com.example.security.inmemory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityControllers {
	
	
	@GetMapping("/testadmin")
	public String testadmin() {
		return "Hello, Admin you are authenticated";
	}
	
	@GetMapping("/testcustomer")
	public String testcustomer() {
		return "Hello, customer you are authenticated";
	}
	@GetMapping("/delete")
	public String deleteCustomer() {
		return "Hello, customer is delete successully....";
	}

}
