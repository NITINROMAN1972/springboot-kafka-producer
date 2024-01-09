package com.deliveryapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.deliveryapp.topic.TopicConstant;

@Service
public class KafkaService {

	// apache-kafka template
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	// lodger
	private Logger logger = LoggerFactory.getLogger(KafkaService.class);
	
	// producing the location using apache-kafka template
	public boolean updateLocation (String location) {
		
		// send() method uses topic and data
		kafkaTemplate.send(TopicConstant.LOCATION_TOPIC_UPDATE, location);
		logger.info("location produced");
		return true;
	}
}
