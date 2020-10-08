package com.motors.followup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.motors.followup.request.AddVisitorRequest;
import com.motors.followup.service.VisitorService;

@Controller
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

	@GetMapping(value = "/fetch-all")
	public String fetchAllVisitor(Model model) {
		model.addAttribute("visitors",visitorService.fetchAllVisitor());
		return "fetch-all-visitors";
	}

	@DeleteMapping(value = "/delete")
	public ResponseEntity<Object> deleteVisitor(@RequestParam Long visitorId) {
		int response = visitorService.deleteVisitor(visitorId);
		if (response == 1) {
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
		return new ResponseEntity<Object>(HttpStatus.METHOD_FAILURE);
	}
	
}
