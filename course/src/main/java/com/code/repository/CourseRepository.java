package com.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
