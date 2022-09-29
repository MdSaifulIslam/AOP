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
		
		accountDAO.addAccount();
		
		System.out.println("\nTry Membership DAO\n");
		
		MembershipDAO membershipDAO = 
				context.getBean("membershipDAO", MembershipDAO.class);
		
		membershipDAO.addAccount4Membership();

	}

}
