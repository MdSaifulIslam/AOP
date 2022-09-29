package com.springdemo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyLoggignAspect {

	@Before("com.springdemo.aopdemo.aspect.AspectExpression.pointCutTest()")
	public void beforeAddAccoutAdvice() {
		System.out.println(getClass() + " This is the pre-work to done");
	}
}
