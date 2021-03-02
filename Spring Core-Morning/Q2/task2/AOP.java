package com.au.task2;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@EnableAspectJAutoProxy
@Component
@Aspect

public class AOP {

	@Before("pointBreak()")
    public static void beforeAnnotation() {
        System.out.println("Before calling the method");
    }
	
	@After("pointBreak()")
    public static void afterAnnotation() {
        System.out.println("after calling the method");
    }
	
	@Pointcut("execution (public void getName())")
    public void pointBreak() {
    	System.out.println("Pointbreak executed");
    }
	
	@AfterReturning(pointcut = "execution(int getRollnumber())", returning = "roll")
    public void afterreturningannotation(int roll) {
        System.out.println("After returning annotation. Returned roll number = " + roll);
    }
}
