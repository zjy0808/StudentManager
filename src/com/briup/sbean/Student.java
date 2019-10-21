package com.briup.sbean;

public class Student {
	private String name;
	private String classString;
	private int grade;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassString() {
		return classString;
	}
	public void setClassString(String classString) {
		this.classString = classString;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public Student(String name, String classString, int grade) {
		super();
		this.name = name;
		this.classString = classString;
		this.grade = grade;
	}
	
}
