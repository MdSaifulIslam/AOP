package com.springdemo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggignAspect {

	@Before("execution(* add*())")
	public void beforeAddAccoutAdvice() {
		System.out.println(getClass() + " This is the pre-work to done");
	}
}
