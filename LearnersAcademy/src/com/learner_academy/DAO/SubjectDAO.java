package com.learner_academy.DAO;

import java.util.List;

import com.learner_academy.model.Subject;

public interface SubjectDAO {
	// CRUD methods for Subject
	public Subject createSubject(Subject subject);

	public Subject getSubjectById(int subjectId);

	public List<Subject> getAllSubject();

	public Subject updateSubject(Subject subject);

	public void removeSubject(int subjectId);
}
