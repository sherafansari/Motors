package com.motors.followup.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

@Order(1)
public class TransactionFilter implements Filter {
	private static final Logger logger = LoggerFactory.getLogger(TransactionFilter.class);

	@Override
	public void init(final FilterConfig filterConfig) throws ServletException {
		logger.info("Initializing filter :{}", this);
	}

	@Override
	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		logger.info("Starting a transaction for req : {}", req.getRequestURI());
		chain.doFilter(request, response);
		logger.info("Committing a transaction for req : {}", req.getRequestURI());
	}

	@Override
	public void destroy() {
		logger.warn("Destructing filter :{}", this);
	}

}
