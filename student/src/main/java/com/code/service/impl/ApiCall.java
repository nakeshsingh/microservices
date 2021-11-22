package com.code.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.code.model.Course;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class ApiCall {
	private static final Logger logger = LoggerFactory.getLogger(ApiCall.class);
	@Autowired RestTemplate restTemplate;
	
	private static final String courseMisroserviceBaseURL = 
			"http://course-service";
	
	@CircuitBreaker(name = "example", fallbackMethod="fallback")
	public Course getCourseDetails(int courseId) {
		logger.info("calling course microservice API using RestTemplate");
		
		Course course = restTemplate.getForObject(
				courseMisroserviceBaseURL + "/course/id?id={courseId}", 
				Course.class, courseId);
		return course;
	}
	
	public Course fallback(Exception ex) {
		logger.info("calling fallback and returning default course data");
		Course course = new Course();
		course.setId(1);
		course.setName("common-course");
		course.setDuration(1);
		return course;
	} 
}
