package com.springdemo.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.springdemo.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyLoggignAspect {
	
	@After(
			"execution(* com.springdemo.aopdemo.dao.AccountDAO.findAccount(..))"
			)
	public void afterFinallyFindAccountAdvice(
			JoinPoint theJoinPoint
			) {
		
		System.out.println("Always print after the method");	
		
	}
	@AfterReturning(
			pointcut = "execution(* com.springdemo.aopdemo.dao.AccountDAO.findAccount(..))",
			returning = "returnedData"
			)
	public void afterReturningFindAccountAdvice(
			JoinPoint theJoinPoint, List<Account> returnedData
			) {
		
		convertAccountNameToUpperCase(returnedData);
		
		System.out.println("in aspect -returened -modified: " + returnedData);
		
	}
	@AfterThrowing(
			pointcut = "execution(* com.springdemo.aopdemo.dao.AccountDAO.findAccount(..))",
			throwing = "theExp"
			)
	public void afterThrowingFindAccountAdvice(
			JoinPoint theJoinPoint, Throwable theExp
			) {
		
		
		System.out.println("in aspect -returened -modified: " + theExp);
		
	}

	private void convertAccountNameToUpperCase(List<Account> returnedData) {
		for (Account account : returnedData) {
			String upperCaseName = account.getName().toUpperCase();
			account.setName(upperCaseName);
		}
		
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
