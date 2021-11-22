package com.code.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.code.entity.Course;
import com.code.service.CourseService;

@RestController
@RequestMapping(value= "/course")
@RefreshScope
public class CourseController {
	
	@Autowired CourseService courseService;
	
	@Value("${message:default message}")
    private String message;
	
	@GetMapping("/message")
	public String getMessage() {
		return message;
	}
	
	@PostMapping
	public boolean create(@RequestBody Course course) {
		return courseService.create(course);
	}
	
	@GetMapping
	public List<Course> getAll() {
		return courseService.getAll();
	}
	
	@GetMapping("/id")
	public Course getById(@RequestParam(value = "id", defaultValue = "1") int id) {
		return courseService.getById(id);
	}
	
	@PutMapping
	public boolean update(@RequestBody Course course) {
		return courseService.update(course);
	}
	
	@DeleteMapping 
	public boolean delete(@RequestParam int id) {
		return courseService.delete(id);
	}
}
