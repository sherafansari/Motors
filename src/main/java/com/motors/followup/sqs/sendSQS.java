package com.motors.followup.sqs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class sendSQS {
	@Autowired
	public static final Logger LOGGER = LoggerFactory.getLogger(sendSQS.class);

	@Autowired
	private QueueMessagingTemplate queueMessagingTemplate;

	@Value("${cloud.aws.sqs.url}")
	private String endpoint;

	@Scheduled(fixedRate = 100)
	public void scheduleFixedRateTask() {
		LOGGER.info("Sending Message to SQS ");
		queueMessagingTemplate.send(endpoint,
				MessageBuilder.withPayload("This is my java first queue message.").build());
		// queueMessagingTemplate.convertAndSend(endpoint, new Pojo("SomeRandomValue"));

	}
}
