package com.springdemo.aopdemo.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import java.util.List;

import org.aspectj.lang.*;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.springdemo.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyLoggignAspect {
	
	@AfterReturning(
			pointcut = "execution(* com.springdemo.aopdemo.dao.AccountDAO.findAccount(..))",
			returning = "returnedData"
			)
	public void afterReturningFindAccountAdvice(
			JoinPoint theJoinPoint, List<Account> returnedData
			) {
		
		System.out.println("After returning-----" + returnedData);
		
	}

	@Before("com.springdemo.aopdemo.aspect.AspectExpression.pointCutTest()")
	public void beforeAddAccoutAdvice(JoinPoint theJoinPoint) {
		System.out.println(" This is the pre-work to done - Logging");
		
		MethodSignature sign = (MethodSignature)theJoinPoint.getSignature();
		
		Object[] args = theJoinPoint.getArgs();
		
		System.out.println("Signature of - " + sign);
		
		for (Object object : args) {
			System.out.println("Args - " + object);
			
			if(object instanceof Account) {
				Account tempAccount = (Account) object;
				System.out.println("Account args - " + tempAccount.getEmail());
				System.out.println("Account args - " + tempAccount.getName());
			}
		}
	}
}
