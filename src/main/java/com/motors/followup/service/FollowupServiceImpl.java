package com.motors.followup.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motors.followup.model.FollowupDetails;
import com.motors.followup.repository.FollowupRepository;
import com.motors.followup.request.AddFollowupRequest;

@Service
public class FollowupServiceImpl implements FollowupService {

	public static final Logger LOGGER = LoggerFactory.getLogger(FollowupServiceImpl.class);

	@Autowired
	FollowupRepository followupRepository;

	@Override
	public int addFollowup(AddFollowupRequest addFollowupRequest) {
		try {
			FollowupDetails followupDetails = new FollowupDetails();
			followupDetails.setCreatedTimestamp(new Date());
			followupDetails.setModel(addFollowupRequest.getModel());
			followupDetails.setNextFollowupDate(addFollowupRequest.getNextFollowupDate());
			followupDetails.setPaymentMode(addFollowupRequest.getPaymentMode());
			followupDetails.setStatus(addFollowupRequest.getStatus());
			followupDetails.setVisitorId(addFollowupRequest.getVisitorId());

			followupRepository.save(followupDetails);
			return 1;
		} catch (Exception e) {
			LOGGER.error("error in addFollowup :", e);
		}
		return -1;
	}

}
