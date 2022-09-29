package com.springdemo.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean addAccount4Membership() {
		System.out.println(getClass() + ":- ADDING: add new membership account");
		
		return true;
	}
}
