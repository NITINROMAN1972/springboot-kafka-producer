package com.deliveryapp.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliveryapp.service.KafkaService;

@RestController
@RequestMapping("/location")
public class LocationController {

	private KafkaService kafkaService;
	
	// constructor injection
	public LocationController(KafkaService kafkaService) {
		super();
		this.kafkaService = kafkaService;
	}

	// creating a topic
	@PostMapping("/update")
	public ResponseEntity<?> updateLocation(){
		
		// using random numbers representing the live coordinates -- latitude and longitude
		for(int i =0; i < 100000; i++) {
			kafkaService.updateLocation("(" + Math.round(Math.random()*100) + ", " + Math.round(Math.random()*100) + ")");
		}
		return new ResponseEntity<>(Map.of("message", "location updated"), HttpStatus.OK);
		
		// kafkaService.updateLocation("(" + Math.round(Math.random()*100) + ", " + Math.round(Math.random()*100) + ")");
		// return new ResponseEntity<>(Map.of("message", "location updated"), HttpStatus.OK);
	}
}
