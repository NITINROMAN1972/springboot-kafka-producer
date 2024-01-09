package com.deliveryapp.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import com.deliveryapp.topic.TopicConstant;

@Configuration
public class kafkaConfig {

	// object of topic, to create new topics
	// new topics are created using the producer
	@Bean
	public NewTopic topic() {
		
		return TopicBuilder.name(TopicConstant.LOCATION_TOPIC_UPDATE).build();
		//.partitions().replicas()
	}
}
