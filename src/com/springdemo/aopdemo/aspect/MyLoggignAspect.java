package com.springdemo.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import javax.naming.spi.DirStateFactory.Result;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	Logger logger = Logger.getLogger(getClass().getName());
	
	@Around(
			"execution(* com.springdemo.aopdemo.service.TrafficService.getService(..))"
			)
	public Object aroundgetServiceAdvice(
			ProceedingJoinPoint proceedingJoinPoint
			) throws Throwable {
		
		long begain = System.currentTimeMillis();
		
		Object result;
		
		try {
			result =  proceedingJoinPoint.proceed();
		} catch (Exception e) {
			logger.warning( "---:::---" + e.getMessage());
			
		    throw e;
		}
		
		long end = System.currentTimeMillis();
		
		logger.info("duretion: - " + (end-begain) + " miliseconds");
		
		return null;
	}
	
	@After(
			"execution(* com.springdemo.aopdemo.dao.AccountDAO.findAccount(..))"
			)
	public void afterFinallyFindAccountAdvice(
			JoinPoint theJoinPoint
			) {
		
		logger.info("Always print after the method");	
		
	}
	@AfterReturning(
			pointcut = "execution(* com.springdemo.aopdemo.dao.AccountDAO.findAccount(..))",
			returning = "returnedData"
			)
	public void afterReturningFindAccountAdvice(
			JoinPoint theJoinPoint, List<Account> returnedData
			) {
		
		convertAccountNameToUpperCase(returnedData);
		
		logger.info("in aspect -returened -modified: " + returnedData);
		
	}
	@AfterThrowing(
			pointcut = "execution(* com.springdemo.aopdemo.dao.AccountDAO.findAccount(..))",
			throwing = "theExp"
			)
	public void afterThrowingFindAccountAdvice(
			JoinPoint theJoinPoint, Throwable theExp
			) {
		
		
		logger.info("in aspect -returened -modified: " + theExp);
		
	}

	private void convertAccountNameToUpperCase(List<Account> returnedData) {
		for (Account account : returnedData) {
			String upperCaseName = account.getName().toUpperCase();
			account.setName(upperCaseName);
		}
		
	}

	@Before("com.springdemo.aopdemo.aspect.AspectExpression.pointCutTest()")
	public void beforeAddAccoutAdvice(JoinPoint theJoinPoint) {
		logger.info(" This is the pre-work to done - Logging");
		
		MethodSignature sign = (MethodSignature)theJoinPoint.getSignature();
		
		Object[] args = theJoinPoint.getArgs();
		
		logger.info("Signature of - " + sign);
		
		for (Object object : args) {
			logger.info("Args - " + object);
			
			if(object instanceof Account) {
				Account tempAccount = (Account) object;
				logger.info("Account args - " + tempAccount.getEmail());
				logger.info("Account args - " + tempAccount.getName());
			}
		}
	}
}
