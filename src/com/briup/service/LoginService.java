package com.briup.service;

import java.awt.List;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.briup.sframe.LoginFrame;
import com.briup.sframe.StudentsFrame;
import com.briup.sframe.SucceeFrame;
import com.briup.sframe.*;
@SuppressWarnings("all")
public class LoginService {
	
	//private HashMap<String, String> map = new HashMap<>();
	static Map<String,String> map=new HashMap<>();
	
	static {
		map.put("tom", "1234");
		map.put("bob", "123");
		map.put("jack", "456");
		map.put("marry", "789");
		map.put("tony", "987");
		map.put("lily", "321");
		
	}


	public boolean login(String name, String passsword) throws Exception {
		if(name==null||"".equals(name)) {
			throw new Exception("用户名不能为空");
		}
		if(passsword==null||"".equals(passsword)) {
			throw new Exception("密码不能为空");
		}
		if(map.containsKey(name)) {
			if(map.get(name).equals(passsword)) {
				new StudentsFrame();
				return true;
			}else {
				throw new Exception("用户名密码错误");
			}
		}else {
			throw new Exception("用户名不存在");
		}
	}

	public boolean verify(String name, String password) throws Exception {
		return false;
	}
}
