package com.au.task1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Rectangle {

	private int height;
	private int width;
	
	@Autowired
	@Qualifier("pt1")
	private Point pt1;
	
	@Autowired
	@Qualifier("pt2")
	private Point pt2;
	
	@Autowired
	@Qualifier("pt3")
	private Point pt3;
	
	@Autowired
	@Qualifier("pt4")
	private Point pt4;
	
	public Rectangle(int h,int w) {
		this.height=h;
		this.width=w;
	}
	
	
	//Getters and Setters for all points
	
	public Point getPoint1() {
		return pt1;
	}
	public void setPoint1(Point pt1) {
		this.pt1 = pt1;
	}
	public Point getPoint2() {
		return pt2;
	}
	public void setPoint2(Point pt2) {
		this.pt2 = pt2;
	}
	public Point getPoint3() {
		return pt3;
	}
	public void setPoint3(Point point3) {
		this.pt3 = point3;
	}
	public Point getPoint4() {
		return pt4;
	}
	public void setPoint4(Point point4) {
		this.pt4 = point4;
	}
	
	// Draw rectangle
	
	public void draw() {
		System.out.println("Point 1 x: "+pt1.x +" y: "+pt1.y);
		System.out.println("Point 2 x: "+pt2.x +" y: "+pt2.y);
		System.out.println("Point 3 x: "+pt3.x +" y: "+pt3.y);
		System.out.println("Point 4 x: "+pt4.x +" y: "+pt4.y);
		System.out.println("Length: "+this.height+" Width: "+this.width);
	}

}
