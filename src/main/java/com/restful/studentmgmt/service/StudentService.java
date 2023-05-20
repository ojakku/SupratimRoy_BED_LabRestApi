package com.restful.studentmgmt.service;

import java.util.List;

import com.restful.studentmgmt.entity.Student;

public interface StudentService {
	
	List<Student> getAllStudents();
	void addOrUpdate(Student student);
	void deleteByStudentId(int id);
	Student getStudentById(int id);
	
}
