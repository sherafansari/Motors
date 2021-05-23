package com.motors.followup.sqs;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;

@Component

public class ReceiveMessageFromSQS {
	@Autowired
	public static final Logger LOGGER = LoggerFactory.getLogger(ReceiveMessageFromSQS.class);
	@Value("${cloud.aws.sqs.url}")
	private String sqsUrl;

	@Autowired
	private AmazonSQS amazonSQS;

	@Scheduled(fixedRate = 1000)
	public void receive() {

		final ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(sqsUrl).withMaxNumberOfMessages(1)
				.withWaitTimeSeconds(3);

		while (true) {
			final List<Message> messages = amazonSQS.receiveMessage(receiveMessageRequest).getMessages();
			for (Message messageObject : messages) {
				String message = messageObject.getBody();
				LOGGER.info("Received message: " + message);
				// delete messages from the queue
				amazonSQS.deleteMessage(sqsUrl, messageObject.getReceiptHandle());
			}
		}
	}
}
