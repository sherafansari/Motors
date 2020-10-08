package com.motors.followup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.motors.followup.request.AddFollowupRequest;
import com.motors.followup.service.FollowupService;

@Controller
public class followupController {
	
	@Autowired
	FollowupService followupService;
	
	@SuppressWarnings("deprecation")
	@PostMapping(value = "/addFollowup")
	public ResponseEntity<Object> addFollowup( @RequestBody AddFollowupRequest addFollowupRequest) {
		int response = followupService.addFollowup(addFollowupRequest);
		if (response == 1) {
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
		return new ResponseEntity<Object>(HttpStatus.METHOD_FAILURE);
	}
	
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("message", "Hello world");
		
		return "helloworld";
	}
	
	@GetMapping("/helloJS")
	public String helloJS() {
		
		return "add-css-jss-demo";
	}
}
