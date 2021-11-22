package com.code.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.model.Course;
import com.code.model.Student;
import com.code.model.StudentDetail;
import com.code.repository.StudentRepository;
import com.code.service.StudentService;

import reactor.core.publisher.Mono;

@Service
public class StudentServiceImp implements StudentService {

	@Autowired StudentRepository studentRepository;
	@Autowired ApiCall apiCall;   // using restTemplate
	@Autowired ApiCallUsingWebClient apiCallUsingWebClient; // using webClient
	
	@Override
	public StudentDetail getById(int id) {
		// getting student from table by passing id
		Student s = studentRepository.findById(id).orElse(null);
		
		//getting course from course microservice by call API
		Course course = apiCall.getCourseDetails(s.getCourseId());
		
		StudentDetail sd = new StudentDetail();
		BeanUtils.copyProperties(s, sd);
		sd.setCourse(course);
		return sd;
	}
	
	@Override
	public StudentDetail getByIdUsingWebClient(int id) {
		// getting student from table by passing id
		Student s = studentRepository.findById(id).orElse(null);
		
		//getting course from course microservice by call API
		Mono<Course> courseMono = apiCallUsingWebClient.getCourseDetails(s.getCourseId());
		Course course = courseMono.block();
		
		StudentDetail sd = new StudentDetail();
		// copying properties from student to studentdetail object
		BeanUtils.copyProperties(s, sd);
		sd.setCourse(course);
		return sd;
	}

	@Override
	public Student getByName(String name) {
		Student s = studentRepository.findByName(name);
		return s;
	}

	@Override
	public boolean save(Student student) {
	//	System.out.println("id-" + student.getId() + ", name-" + student.getName() + ", mobileNo-" + student.getMobileNo());
		studentRepository.save(student);
		return true;
	}

	@Override
	public boolean delete(int id) {
		studentRepository.deleteById(id);
		return true;
	}

	@Override
	public boolean update(Student student) {
		studentRepository.save(student);
		return true;
	}

}
