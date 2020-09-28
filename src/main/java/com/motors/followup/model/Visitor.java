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
@Table(name = "visitor")
public class Visitor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "visitor_id")
	private Long visitorId;

	@Column(name = "visitor_name")
	private String visitorName;

	private String address;

	private String profession;

	@Column(name = "phone_no")
	private String phoneNo;

	@Column(name = "salesman_name")
	private String salesmanName;

	@Temporal(TemporalType.DATE)
	@Column(name = "created_timestamp")
	private Date createdTimestamp;

	@Temporal(TemporalType.DATE)
	@Column(name = "modified_timestamp")
	private Date modifiedTimestamp;

}
