package com.learner_academy.model;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Classes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "classId" , updatable = false, nullable = true)
	private int classId;
	@Column(nullable = true)
	private String className;
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "student_classes" , joinColumns ={ @JoinColumn(name = "classId") } , inverseJoinColumns = { @JoinColumn(name = "studentId") })
	private List<Student> students = new ArrayList<>();
	
	public List<Student> getStudent() {
		return students;
	}

	public void setStudent(List<Student> students) {
		this.students = students;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER )
	@JoinTable(name = "subject_classes" , joinColumns ={ @JoinColumn(name = "classId") } , inverseJoinColumns = { @JoinColumn(name = "subjectId") })
	private List<Subject> subjects = new ArrayList<>();
	
	public List<Subject> getSubject() {
		return subjects;
	}

	public void setSubject(List<Subject> subjects) {
		this.subjects = subjects;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "teacher_classes" , joinColumns ={ @JoinColumn(name = "classId") } , inverseJoinColumns = { @JoinColumn(name = "teacherId") })
	private List<Teacher> teachers = new ArrayList<>();
		
	public List<Teacher> getTeacher() {
		return teachers;
	}

	public void setTeacher(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Classes(String className, List<Student> students, List<Subject> subjects, List<Teacher> teachers) {
		super();
		this.className = className;
		this.students = students;
		this.subjects = subjects;
		this.teachers = teachers;
	}

	@Override
	public String toString() {
		return "Classes [classId=" + classId + ", className=" + className + ", students=" + students + ", subjects="
				+ subjects + ", teachers=" + teachers + "]";
	}

	public Classes() {
	
	}


}
