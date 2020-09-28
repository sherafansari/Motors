package com.motors.followup.service;

import java.util.List;

import com.motors.followup.DTO.VisitorDTO;
import com.motors.followup.request.AddVisitorRequest;

public interface VisitorService {
	public int addVisitor(AddVisitorRequest addVisitorRequest);

	public int updateVisitor(AddVisitorRequest addVisitorRequest, Long visitorId);
	
	public List<VisitorDTO> fetchAllVisitor();
	
	public int deleteVisitor(Long visitorId);
}
