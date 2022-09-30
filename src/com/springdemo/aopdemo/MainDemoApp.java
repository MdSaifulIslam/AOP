package com.springdemo.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springdemo.aopdemo.dao.AccountDAO;

public class MainDemoApp {

	private static AnnotationConfigApplicationContext context;

	public static void main(String[] args) {
		context = new AnnotationConfigApplicationContext(DemoConfig.class);

		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

		List<Account> theAccounts = null;

		try {

			boolean tripWire = true;

			theAccounts = accountDAO.findAccount(tripWire);
		} catch (Exception e) {
			System.out.println("error in main - " + e);
		}

		System.out.println("\n-in main-  " + theAccounts + "\n");

		context.close();

		// Account acc = new Account();
		// acc.setEmail("fdshkfg");
		// acc.setName("dfsfgdfggfgfgfgfg");
		//
		// accountDAO.addAccount(acc);
		//
		//// accountDAO.doSomething();
		////
		// accountDAO.setEmail("dsas");
		//
		// MembershipDAO membershipDAO =
		// context.getBean("membershipDAO", MembershipDAO.class);
		//
		// membershipDAO.addAccount4Membership();

	}

}
