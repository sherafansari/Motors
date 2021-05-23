package com.motors.followup.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;

@Configuration
public class Sqsconfiguration {
	@Value("${cloud.aws.region.static}")
	private String region;

	@Value("${cloud.aws.credentials.access-key}")
	private String awsAccessKey;

	@Value("${cloud.aws.credentials.secret-key}")
	private String awsSecretKey;

	@Bean
	public QueueMessagingTemplate queueMessagingTemplate() {
		return new QueueMessagingTemplate(amazonSQSAsync());
	}

	@Bean
	public AmazonSQS amazonSQSClientBuilder() {

		AWSCredentials credentials = new BasicAWSCredentials(awsAccessKey, awsSecretKey);
		return AmazonSQSClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials))
				.withRegion(region).build();

	}

	@Bean
	@Primary
	public AmazonSQSAsync amazonSQSAsync() {

		AWSCredentials credentials = new BasicAWSCredentials(awsAccessKey, awsSecretKey);
		return AmazonSQSAsyncClientBuilder.standard().withRegion(region)
				.withCredentials(new AWSStaticCredentialsProvider(credentials)).build();
	}
}
