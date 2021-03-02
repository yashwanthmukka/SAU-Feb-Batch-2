package com.au.task1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);
		
		Rectangle r1 = ac.getBean(Rectangle.class);
		Rectangle r2 = ac.getBean(Rectangle.class);
		
		
		r1.draw();
		r2.draw();

	}
}
