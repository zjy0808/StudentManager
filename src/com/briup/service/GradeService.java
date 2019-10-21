package com.briup.service;

import java.util.ArrayList;
import java.util.List;

import com.briup.sbean.Student;

public class GradeService {
	private static List<Student> JD1910List, JD1911List, JD1912List;
	{
		JD1910List = new ArrayList<Student>();
		JD1911List = new ArrayList<Student>();
		JD1912List = new ArrayList<Student>();
	}

	public boolean input(String name, String classString, String grade) throws Exception {
		if (name == null || "".equals(name)) {
			throw new Exception("请输入学生姓名");
		} else if (grade == null || "".equals(grade)) {
			throw new Exception("请输入成绩");
		}
		try {
			Integer.parseInt(grade);
		} catch (Exception e) {
			throw new Exception();
		}
		Student student = new Student(name, classString, Integer.parseInt(grade));
		switch (student.getClassString()) {
		case "JD1910":
			JD1910List.add(student);
			break;
		case "JD1911":
			JD1911List.add(student);
			break;
		case "JD1912":
			JD1912List.add(student);
			break;
		default:
			break;
		}

		return true;

	}

	public List<Student> getStudents(){
		ArrayList<Student> list=new ArrayList<Student>();
		list.addAll(JD1910List);
		list.addAll(JD1911List);
		list.addAll(JD1912List);
		return list;
	}
	
	public String getAvg() {
		String msg="";
		if(JD1910List.size()<1) {
			msg+="JD1910班暂无成绩录入！"+"\n";	
		}else {
			int num=0;
			for(Student student:JD1910List) {
				num+=student.getGrade();
			}
			msg+="JD1910班的平均成绩是："+num/JD1910List.size();
		}
		
		if(JD1911List.size()<1) {
			msg+="JD1911班暂无成绩录入！"+"\n";	
		}else {
			int num=0;
			for(Student student:JD1911List) {
				num+=student.getGrade();
			}
			msg+="JD1911班的平均成绩是："+num/JD1911List.size();
		}
		
		if(JD1910List.size()<1) {
			msg+="JD1912班暂无成绩录入！"+"\n";	
		}else {
			int num=0;
			for(Student student:JD1910List) {
				num+=student.getGrade();
			}
			msg+="JD1912班的平均成绩是："+num/JD1912List.size();
		}
		
		return msg;
	}
}
