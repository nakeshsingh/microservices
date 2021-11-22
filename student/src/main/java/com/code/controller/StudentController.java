package com.code.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.code.model.Student;
import com.code.model.StudentDetail;
import com.code.service.StudentService;

@RestController
@RequestMapping("/student")
@RefreshScope
public class StudentController {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	@Autowired StudentService studentService;
	
	@Value("${message:default message}")
    private String message;
	
	@GetMapping("/message")
	public String getMessage() {
		return message;
	}
	
	@GetMapping("/id")
	public StudentDetail getById(@RequestParam(value = "id", defaultValue = "1") int id) {
		logger.info("/id");
		return studentService.getById(id);
	}
	
	@GetMapping("/idwebclient")
	public StudentDetail getByIdUsingWebClient(@RequestParam(value = "id", defaultValue = "1") int id) {
		logger.info("/idwebclient");
		return studentService.getByIdUsingWebClient(id);
	}
	
	@RequestMapping(value = "/name", method = RequestMethod.GET)
	public Student getByName(@RequestParam(value = "name", defaultValue = "nakesh") String name) {
		return studentService.getByName(name);
	}
	
	@PostMapping("/save")
	public boolean saveStudent(@RequestBody(required = true) Student student) {
		return studentService.save(student);
	}
	
	@DeleteMapping()
	public boolean delete(@RequestParam(value = "id", defaultValue = "1") int id) {
		return studentService.delete(id);
	}
	
	@PutMapping("/update")
	public boolean updateStudent(@RequestBody(required = true) Student student) {
		return studentService.update(student);
	}
}
