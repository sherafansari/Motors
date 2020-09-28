package com.motors.followup.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motors.followup.model.Visitor;
import com.motors.followup.repository.VisitorRepository;
import com.motors.followup.request.AddVisitorRequest;

@Service
public class VisitorServiceImpl implements VisitorService {
	@Autowired
	VisitorRepository visitorRepository;

	@Override
	public int addVisitor(AddVisitorRequest addVisitorRequest) {
		Visitor visitor = new Visitor();
		visitor.setAddress(addVisitorRequest.getAddress());
		visitor.setCreatedTimestamp(new Date());
		visitor.setPhoneNo(addVisitorRequest.getPhoneNo());
		visitor.setProfession(addVisitorRequest.getProfession());
		visitor.setSalesmanName(addVisitorRequest.getSalesmanName());
		visitor.setVisitorName(addVisitorRequest.getVisitorName());
		visitorRepository.save(visitor);
		return 1;
	}

}
