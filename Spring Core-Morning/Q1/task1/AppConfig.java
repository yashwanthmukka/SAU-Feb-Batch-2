package com.au.task1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.*;

@Configuration
public class AppConfig {

	@Bean
	public Rectangle getRectangle() {
		
		return new Rectangle(10,5);
		
	}
	
	@Bean
	public RectangleTwo getRectangle1() {	
		return new RectangleTwo();
	}
	
	@Bean
	public java.util.List<Point> sendPoints(){
		return Arrays.asList(new Point(0,0),new Point(0,10),new Point(10,0),new Point(10,10));
	}
	
	@Bean(name="pt1")
	public Point getPoint1() {
		return new Point(0,0);
	}
	
	@Bean(name="pt2")
	public Point getPoint2() {
		return new Point(0,5);
	}
	
	@Bean(name="pt3")
	public Point getPoint3() {
		return new Point(5,0);
	}
	
	@Bean(name="pt4")
	public Point getPoint4() {
		return new Point(5,5);
	}

	
}
