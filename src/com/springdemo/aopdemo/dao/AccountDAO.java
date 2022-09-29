package com.springdemo.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.springdemo.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String email;
	private String name;

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
