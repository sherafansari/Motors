package com.motors.followup.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "followup_details")
public class FollowupDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "followup_id")
	private Long followupId;

	@Column(name = "model")
	private String model;

	@Column(name = "status")
	private String status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "next_followup_date")
	private Date nextFollowupDate;

	@Column(name = "payment_mode")
	private String paymentMode;

	@Column(name = "visitor_id")
	private Long visitorId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_timestamp")
	private Date createdTimestamp;

}
