package com.au.task2;

import org.springframework.stereotype.Component;

@Component
public class Student {

	String name = "Yashwanth";
	int rollno = 120;
	
	public void getName() {

		System.out.println("Name:" + name);
		
	}

	public int getRoll() {
		// TODO Auto-generated method stub
		return rollno;
	}

	public void getCourse(String string) throws  Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Course = " + string);
        throw new RuntimeException();
	}

}
