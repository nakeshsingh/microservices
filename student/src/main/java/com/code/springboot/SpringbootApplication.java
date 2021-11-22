package com.code.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@ComponentScan(basePackages = "com.code")
@EntityScan("com.code.model")
@EnableJpaRepositories(basePackages = "com.code.repository")
/*
 * @PropertySources({
 * 
 * @PropertySource({"file:C:\\Users\\Admin\\microservice\\student.properties"})
 * })
 */
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	@Bean
	@LoadBalanced
	WebClient.Builder webClientBuilder() {
	  return WebClient.builder();
	}
}
