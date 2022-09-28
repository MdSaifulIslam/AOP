package com.springdemo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggignAspect {

	@Before("execution(public void addAccount())")
	public void beforeAddAccoutAdvice() {
		System.out.println("This is the pre-work to done");
	}
}
