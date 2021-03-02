package com.au.task1;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

public class RectangleTwo {

	private Point pt1;
	private Point pt2;
	private Point pt3;
	private Point pt4;
	
	@Autowired
	public void getPoints(List<Point> points) {
		this.pt1=points.remove(0);
		this.pt2=points.remove(0);
		this.pt3=points.remove(0);
		this.pt4=points.remove(0);
	}
	
	public void draw() {
		System.out.println("In Rectangle1");
		System.out.println("Point 1 x: "+pt1.x +" y: "+pt1.y);
		System.out.println("Point 2 x: "+pt2.x +" y: "+pt2.y);
		System.out.println("Point 3 x: "+pt3.x +" y: "+pt3.y);
		System.out.println("Point 4 x: "+pt4.x +" y: "+pt4.y);
		
	}
}
