package com.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
 * @PropertySources({
 * 
 * @PropertySource({"file:C:\\Users\\Admin\\microservice\\course.properties"})
 * })
 */
public class CourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseApplication.class, args);
	}

}
