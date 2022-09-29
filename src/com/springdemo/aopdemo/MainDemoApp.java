package com.springdemo.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springdemo.aopdemo.dao.AccountDAO;
import com.springdemo.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	private static AnnotationConfigApplicationContext context;

	public static void main(String[] args) {
		context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = 
				context.getBean("accountDAO", AccountDAO.class);
		Account acc = new Account();
////		accountDAO.addAccount(acc);
//		accountDAO.doSomething();
//		
		accountDAO.setEmail("dsas");
		
		MembershipDAO membershipDAO = 
				context.getBean("membershipDAO", MembershipDAO.class);
		
//		membershipDAO.addAccount4Membership();

	}

}
