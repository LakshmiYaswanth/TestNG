package com.revature.testng.demo;

import org.testng.annotations.Test;

public class DemoV1 {
	
	
	@Test
	public void startBrowser() {
		System.out.println("Started the browser");
	}
	@Test
	public void Login() {
		System.out.println("created the login");
	}
	@Test 
	public void logout() {
		System.out.println("logout was done");
	}

}
