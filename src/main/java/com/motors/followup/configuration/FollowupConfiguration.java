package com.motors.followup.configuration;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.motors.followup.filters.RequestLoggingFilter;

@SpringBootConfiguration
public class FollowupConfiguration {
	@Bean
	public FilterRegistrationBean<RequestLoggingFilter> loggingFilter() {
		FilterRegistrationBean<RequestLoggingFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new RequestLoggingFilter());
		registrationBean.setName("requestLoggingFilter");
		registrationBean.setOrder(2);
		registrationBean.addUrlPatterns("/*");

		return registrationBean;
	}
}
