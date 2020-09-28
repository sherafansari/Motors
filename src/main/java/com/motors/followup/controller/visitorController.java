package com.motors.followup.controller;

import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.motors.followup.DTO.VisitorDTO;
import com.motors.followup.request.AddVisitorRequest;
import com.motors.followup.service.VisitorService;

@RestController
@RequestMapping("/visitor")
public class visitorController {

	@Autowired
	VisitorService visitorService;

	@PostMapping(value = "/add")
	public ResponseEntity<Object> addVisitor(@RequestBody AddVisitorRequest addVisitorRequest) {
		int response = visitorService.addVisitor(addVisitorRequest);
		if (response == 1) {
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
		return new ResponseEntity<Object>(HttpStatus.METHOD_FAILURE);
	}
	
	@SuppressWarnings("deprecation")
	@PutMapping(value = "/update")
	public ResponseEntity<Object> updateVisitor(@RequestBody AddVisitorRequest addVisitorRequest, @RequestParam Long visitorId) {
		int response = visitorService.updateVisitor(addVisitorRequest, visitorId);
		if (response == 1) {
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
		return new ResponseEntity<Object>(HttpStatus.METHOD_FAILURE);
	}
	
	@PutMapping(value = "/fetch-all")
	public ResponseEntity<Object> fetchAllVisitor(@RequestBody AddVisitorRequest addVisitorRequest) {
		List<VisitorDTO> response = visitorService.fetchAllVisitor();
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}

	@PutMapping(value = "/delete")
	public ResponseEntity<Object> deleteVisitor(@RequestBody Long visitorId) {
		int response = visitorService.deleteVisitor(visitorId);
		if (response == 1) {
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
		return new ResponseEntity<Object>(HttpStatus.METHOD_FAILURE);
	}
	
}
