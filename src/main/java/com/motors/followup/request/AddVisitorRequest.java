package com.motors.followup.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddVisitorRequest {
	private String visitorName;
	private String address;
	private String profession;
	private String phoneNo;
	private String salesmanName;

}
