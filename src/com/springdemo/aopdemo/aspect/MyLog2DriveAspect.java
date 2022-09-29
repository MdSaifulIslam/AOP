package com.springdemo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyLog2DriveAspect {
	
	@Before("com.springdemo.aopdemo.aspect.AspectExpression.pointCutTest()")
	public void beforeAddDriveAdvice() {
		System.out.println(" This is the pre-work to done - drive");
	}
}
