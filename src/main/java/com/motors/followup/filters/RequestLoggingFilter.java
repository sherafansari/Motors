package com.motors.followup.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestLoggingFilter implements Filter {
	private static final Logger logger = LoggerFactory.getLogger(RequestLoggingFilter.class);

	@Override
	public void init(final FilterConfig filterConfig) throws ServletException {
		logger.info("Initializing filter :{}", this);
	}

	@Override
	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		logger.info("Logging Request: {} :: {}", req.getMethod(), req.getRequestURI());
		chain.doFilter(request, response);
		logger.info("Logging Response: {}", res.getContentType());

	}

	@Override
	public void destroy() {
		logger.info("Destroying filter :{}", this);
	}
}
