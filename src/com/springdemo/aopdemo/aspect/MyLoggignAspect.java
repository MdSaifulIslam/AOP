package com.springdemo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggignAspect {

	@Pointcut("execution(* com.springdemo.aopdemo.dao.*.*(..))")
	private void pointCutTest() {}
	
	@Pointcut("execution(* com.springdemo.aopdemo.dao.*.set*(..))")
	private void setterPointCut() {}
	
	@Pointcut("execution(* com.springdemo.aopdemo.dao.*.get*(..))")
	private void getterPointCut() {}
	
	@Pointcut("pointCutTest() && !(getterPointCut() || setterPointCut())")
	private void noGetterSetter() {}
	
	
	
	@Before("pointCutTest()")
	public void beforeAddAccoutAdvice() {
		System.out.println(getClass() + " This is the pre-work to done");
	}
	
//	@Before("noGetterSetter()")
//	public void beforeAddAccoutAdviceTestPointCut() {
//		System.out.println(getClass() + "-beforeAddAccoutAdviceTestPointCut This is the pre-work to done");
//	}
}
