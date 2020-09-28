package com.motors.followup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.motors.followup.request.AddFollowupRequest;
import com.motors.followup.service.FollowupService;

@RestController
public class followupController {
	
	@Autowired
	FollowupService followupService;
	
	@SuppressWarnings("deprecation")
	@PostMapping(value = "/addFollowup")
	public ResponseEntity<Object> addFollowup(@RequestBody AddFollowupRequest addFollowupRequest) {
		int response = followupService.addFollowup(addFollowupRequest);
		if (response == 1) {
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
		return new ResponseEntity<Object>(HttpStatus.METHOD_FAILURE);
	}
}
