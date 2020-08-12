package com.learner_academy.service;

import java.util.List;

import com.learner_academy.exception.BusinessException;
import com.learner_academy.model.Student;

public interface StudentService {


	//CRUD methods for Student
		public Student createStudent(Student student);
		public Student getStudentById(int studentId) throws BusinessException;
		public List<Student> getAllStudents();
		public Student updateStudent(Student student);
		public void removeStudent(int studentId);
	
}