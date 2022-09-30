package com.springdemo.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springdemo.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String email;
	private String name;
	
	public List<Account> findAccount(){
		List<Account> accounts = new ArrayList<Account>();
		
		accounts.add(new Account("saiful", "saiful@g.com"));
		accounts.add(new Account("Jamal", "jamal@g.com"));
		accounts.add(new Account("kamal", "kamal@g.com"));
		accounts.add(new Account("jabbar", "jabbar@g.com"));
		
		return accounts;
	}

	public void addAccount(Account ac) {
		System.out.println(getClass() + ":- ADDING: add new account");
	}
	public void doSomething() {
		System.out.println(getClass() + ":- ADDING: add new account");
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
		System.out.println("setting email");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
