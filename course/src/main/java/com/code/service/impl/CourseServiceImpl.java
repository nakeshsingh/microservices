package com.code.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Service;

import com.code.entity.Course;
import com.code.repository.CourseRepository;
import com.code.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	private static final Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);
	
	@Autowired CourseRepository courseRepository;
	@Autowired Tracer tracer;
	
	@Override
	public boolean create(Course course) {
		// INSERT INTO course (name, duration) values ('BTech', 4);
		courseRepository.save(course); 
		return true;
	}

	@Override
	public Course getById(int courseId) {
		logger.info("logs before custom span");
		Span newSpan = this.tracer.nextSpan().name("custom-log");
		try (Tracer.SpanInScope ws = this.tracer.withSpan(newSpan.start())) {
		    // ...
		    // You can tag a span
		    newSpan.tag("custom-tag", "##333##");
		    // ...
		    logger.info("Logs in custom span");
		}
		finally {
		    // Once done remember to end the span. This will allow collecting
		    // the span to send it to a distributed tracing system e.g. Zipkin
		    newSpan.end();
		}
		// SELECT * FROM course WHERE id = 1;
		Course course = courseRepository.findById(courseId).orElse(null);
		logger.info("logs after custom span");
		return course;
	}

	@Override
	public List<Course> getAll() {
		// SELECT * FROM course;
		List<Course> courseList = courseRepository.findAll();
		return courseList;
	}

	@Override
	public boolean update(Course course) {
		// UPDATE course SET name='MTech', duration=5 WHERE id = 1;
		courseRepository.save(course);
		return true;
	}

	@Override
	public boolean delete(int courseId) {
		// DELETE FROM course where id = 1;
		courseRepository.deleteById(courseId);
		return true;
	}

}
