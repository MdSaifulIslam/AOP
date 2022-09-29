package com.springdemo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectExpression {
	
	@Pointcut("execution(* com.springdemo.aopdemo.dao.*.*(..))")
	public void pointCutTest() {}
	
	@Pointcut("execution(* com.springdemo.aopdemo.dao.*.set*(..))")
	public void setterPointCut() {}
	
	@Pointcut("execution(* com.springdemo.aopdemo.dao.*.get*(..))")
	public void getterPointCut() {}
	
	@Pointcut("pointCutTest() && !(getterPointCut() || setterPointCut())")
	public void noGetterSetter() {}
	
	
	
	@Before("pointCutTest()")
	public void beforeAddAccoutAdvice() {
		System.out.println(getClass() + " This is the pre-work to done");
	}
	
	@Before("noGetterSetter()")
	public void beforeAddAccoutAdviceTestPointCut() {
		System.out.println(getClass() + "-beforeAddAccoutAdviceTestPointCut This is the pre-work to done");
	}

}
