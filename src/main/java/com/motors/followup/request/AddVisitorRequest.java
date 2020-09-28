package com.motors.followup.request;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddVisitorRequest {
	@NotNull
	private String visitorName;
	private String address;
	private String profession;
	private String phoneNo;
	private String salesmanName;

}
