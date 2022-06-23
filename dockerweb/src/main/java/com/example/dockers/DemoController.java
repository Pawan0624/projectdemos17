package com.example.dockers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	
	@GetMapping("/get")
	public String getMethod() {
		return "get method is working...";
	}
	
	@PostMapping("/post")
	public String postMethod() {
		return "post method is working...";
	}
	
	
	@PutMapping("/put")
	public String putMethod() {
		return "put method is working...";
	}

}
