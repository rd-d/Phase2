package com.learner_academy.DAO;

import java.util.List;

import com.learner_academy.model.Student;

public interface StudentDAO {

//	CRUD methods for Student
	public Student createStudent(Student student);

	public Student getStudentById(int studentId);

	public List<Student> getAllStudents();

	public Student updateStudent(Student student);

	public void removeStudent(int studentId);
}