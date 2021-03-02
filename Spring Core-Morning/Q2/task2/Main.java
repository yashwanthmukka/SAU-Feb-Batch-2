package com.au.task2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		 AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	       Student stu = context.getBean(Student.class);
	       
	       stu.getName();
	       
	       System.out.println(stu.getRoll());
	       
	       stu.getCourse("Computer Science");

	}

}
