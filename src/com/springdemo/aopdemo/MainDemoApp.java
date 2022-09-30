package com.springdemo.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springdemo.aopdemo.service.TrafficService;

public class MainDemoApp {

	private static AnnotationConfigApplicationContext context;
	
	private static Logger logger = 
			Logger.getLogger(MainDemoApp.class.getName());

	public static void main(String[] args) {
		context = new AnnotationConfigApplicationContext(DemoConfig.class);

		TrafficService trafficService = context.getBean("trafficService", TrafficService.class);

		logger.info(trafficService.getService());

		// after after throwing
		// List<Account> theAccounts = null;
		//
		// try {
		//
		// boolean tripWire = false;
		//
		// theAccounts = accountDAO.findAccount(tripWire);
		// } catch (Exception e) {
		// System.out.println("error in main - " + e);
		// }
		//
		// System.out.println("\n-in main- " + theAccounts + "\n");

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
