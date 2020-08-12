package com.learner_academy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "subjectId", updatable = false, nullable = true)
	private int subjectId;
	@Column(nullable = true)
	private String subjectName;
	
	
//	@ManyToMany
//	@JoinColumn(name = "teacherId")
//	private List<Teacher> teac;
//
//	public List<Teacher> getTeac() {
//		return teac;
//	}
//	public void setTeac(List<Teacher> teac) {
//		this.teac = teac;
//	}
	
//	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinTable(name = "subject_classes" , joinColumns ={ @JoinColumn(name = "subjectId") } , inverseJoinColumns = { @JoinColumn(name = "classId") })
//	private List<Classes> classes = new ArrayList<>();
//
//
//	public List<Classes> getClasses() {
//		return classes;
//	}
//	public void setClasses(List<Classes> classes) {
//		this.classes = classes;
//	}
	
	
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}


	public Subject(String subjectName) {
		super();
		this.subjectName = subjectName;
	}
	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectName=" + subjectName + "]";
	}
	public Subject() {
	
	}
	
	
	
}
