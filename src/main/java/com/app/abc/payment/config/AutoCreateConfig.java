package com.app.abc.payment.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class AutoCreateConfig {

	@Bean
	public NewTopic paymentEvent() {
		return TopicBuilder.name("payment-events")
				.partitions(4)
				.replicas(1)
				.build();
	}
}
