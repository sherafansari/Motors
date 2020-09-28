package com.motors.followup.DTO;

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
public class VisitorDTO {
	private Long visitorId;
	private String visitorName;
	private String address;
	private String profession;
	private String phoneNo;
	private String salesmanName;

}
