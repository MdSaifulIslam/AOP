package com.springdemo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.*;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyLoggignAspect {

	@Before("com.springdemo.aopdemo.aspect.AspectExpression.pointCutTest()")
	public void beforeAddAccoutAdvice(JoinPoint theJoinPoint) {
		System.out.println(" This is the pre-work to done - Logging");
		
		MethodSignature sign = (MethodSignature)theJoinPoint.getSignature();
		
		Object[] args = theJoinPoint.getArgs();
		
		System.out.println("Signature of - " + sign);
		
		for (Object object : args) {
			System.out.println("Args - " + object);
		}
	}
}
