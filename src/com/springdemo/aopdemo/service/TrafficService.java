package com.springdemo.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficService {
	
	public String getService() {
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "expect more trafic";
		
	}
	public String getService(boolean tripWire) {
		
		if(tripWire) {
			throw new RuntimeException("cought in error");
		}
		
		return getService();
	}

}
