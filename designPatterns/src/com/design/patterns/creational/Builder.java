package com.design.patterns.creational;

import java.util.*;

abstract class StudentBuiler {
	int id;
	String name;
	int studentClass;
	List<String> subjects;

	public StudentBuiler setId(int id) {
		this.id = id;
		return this;
	}

	public StudentBuiler setName(String name) {
		this.name = name;
		return this;
	}

	public StudentBuiler setStudentClass(int studentClass) {
		this.studentClass = studentClass;
		return this;
	}

	abstract StudentBuiler setSubjects() ;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getStudentClass() {
		return studentClass;
	}

	public List<String> getSubjects() {
		return subjects;
	}

	public Student build() {
		return new Student(this);
	}

}

class EngineeringStudentBuilder extends StudentBuiler{

	@Override
	StudentBuiler setSubjects() {
		this.subjects =Arrays.asList("EME", "M1", "Civil");
		
		return  this;
	}
	
}

class Student {
	private int id;
	private String name;
	private int studentClass;
	private List<String> subjects;

	public Student() {
	}

	public Student(StudentBuiler sb) {
		this.id = sb.getId();
		this.name = sb.getName();
		this.studentClass = sb.getStudentClass();
		this.subjects = sb.getSubjects();
	}
	
	@Override
	public String toString() {
		
		return "The student Details are id "+ id +" Name "+name + " class " + studentClass+" Subjects are "+ subjects;
	}
}

public class Builder {
	public static void main(String[] args) {
		
		StudentBuiler engineeringStudBuilder = new EngineeringStudentBuilder();
		
		Student engStuent = engineeringStudBuilder.setId(1).setName("Akash").setStudentClass(10).setSubjects().build();
		
		String student = engStuent.toString();
		System.out.println(student);
	}
}
