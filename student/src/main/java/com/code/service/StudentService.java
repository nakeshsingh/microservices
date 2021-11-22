package com.code.service;

import com.code.model.Student;
import com.code.model.StudentDetail;

public interface StudentService {
	StudentDetail getById(int id);
	Student getByName(String name);
	boolean save(Student student);
	boolean delete(int id);
	boolean update(Student student);
	StudentDetail getByIdUsingWebClient(int id);
	
}
