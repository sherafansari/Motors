package com.motors.followup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.motors.followup.request.AddVisitorRequest;
import com.motors.followup.service.VisitorService;

@RestController
@RequestMapping("/visitor")
public class visitorController {
	
	@Autowired
	VisitorService visitorService;
	@PostMapping(value = "/add")
	public ResponseEntity<Object> addVisitor(AddVisitorRequest addVisitorRequest){
		int response = visitorService.addVisitor(addVisitorRequest);
		if(response == 1 ) {
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
		return new ResponseEntity<Object>(HttpStatus.METHOD_FAILURE);
	}
}
