package com.motors.followup.request;

import java.util.Date;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddFollowupRequest {

	private String model;
	@NotNull
	private String status;
	private Date nextFollowupDate;
	private String paymentMode;
	@NotNull
	private Long visitorId;
	private Date createdTimestamp;
}
