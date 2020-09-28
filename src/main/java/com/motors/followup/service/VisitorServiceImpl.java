package com.motors.followup.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motors.followup.DTO.VisitorDTO;
import com.motors.followup.model.Visitor;
import com.motors.followup.repository.VisitorRepository;
import com.motors.followup.request.AddVisitorRequest;

@Service
public class VisitorServiceImpl implements VisitorService {
	@Autowired
	VisitorRepository visitorRepository;

	public static final Logger LOGGER = LoggerFactory.getLogger(VisitorServiceImpl.class);

	@Override
	public int addVisitor(AddVisitorRequest addVisitorRequest) {
		try {
			LOGGER.info(addVisitorRequest.toString());
			Visitor visitor = new Visitor();
			visitor.setAddress(addVisitorRequest.getAddress());
			visitor.setCreatedTimestamp(new Date());
			visitor.setPhoneNo(addVisitorRequest.getPhoneNo());
			visitor.setProfession(addVisitorRequest.getProfession());
			visitor.setSalesmanName(addVisitorRequest.getSalesmanName());
			visitor.setVisitorName(addVisitorRequest.getVisitorName());
			visitorRepository.save(visitor);
			return 1;
		} catch (Exception e) {
			LOGGER.error("Error in add Visitor: ", e);
		}
		return -1;
	}

	@Override
	public int updateVisitor(AddVisitorRequest addVisitorRequest, Long visitorId) {
		try {
			Visitor visitor = visitorRepository.findByVisitorId(visitorId);
			visitor.setAddress(addVisitorRequest.getAddress());
			visitor.setModifiedTimestamp(new Date());
			visitor.setPhoneNo(addVisitorRequest.getPhoneNo());
			visitor.setProfession(addVisitorRequest.getProfession());
			visitor.setSalesmanName(addVisitorRequest.getSalesmanName());
			visitor.setVisitorName(addVisitorRequest.getVisitorName());
			visitorRepository.save(visitor);
			return 0;
		} catch (Exception e) {
			LOGGER.error("Error in Update Visitor: ", e);
		}
		return -1;
	}

	@Override
	public List<VisitorDTO> fetchAllVisitor() {
		try {
			List<VisitorDTO> response = new ArrayList<>();
			List<Visitor> visitors = visitorRepository.findAll();
			for (Visitor visitor : visitors) {
				VisitorDTO visitorDTO = new VisitorDTO();

				visitorDTO.setAddress(visitor.getAddress());
				visitorDTO.setPhoneNo(visitor.getPhoneNo());
				visitorDTO.setProfession(visitor.getProfession());
				visitorDTO.setSalesmanName(visitor.getSalesmanName());
				visitorDTO.setVisitorId(visitor.getVisitorId());
				visitorDTO.setVisitorName(visitor.getVisitorName());

				response.add(visitorDTO);
			}
			return response;
		} catch (Exception e) {
			LOGGER.error("Error in fetch all Visitors: ", e);
		}
		return null;
	}

	@Override
	public int deleteVisitor(Long visitorId) {
		try {
			Visitor visitor = visitorRepository.findByVisitorId(visitorId);
			if (Objects.nonNull(visitor)) {
				visitorRepository.deleteById(visitorId);
				return 1;
			}
			return 0;
		} catch (Exception e) {
			LOGGER.error("Error in Delete Visitor: ", e);
		}
		return -1;
	}

}
