package com.learner_academy.service;

import java.util.List;

import com.learner_academy.exception.BusinessException;
import com.learner_academy.model.Subject;

public interface SubjectService {

	// CRUD methods for Subject
	public Subject createSubject(Subject subject);

	public Subject getSubjectById(int subjectId) throws BusinessException;

	public List<Subject> getAllSubject();

	public Subject updateSubject(Subject subject);

	public void removeSubject(int subjectId);

}