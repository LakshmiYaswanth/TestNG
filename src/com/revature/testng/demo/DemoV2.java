package com.revature.testng.demo;

import org.testng.Assert;
import org.testng.annotations.Test;
//Here adding the Dependency between the another test case 
public class DemoV2 {
	@Test
	public void startBrowser() {
		Assert.assertEquals(23, 34);
		System.out.println("Started the browser");
	}
	@Test(dependsOnMethods="startBrowser")
	public void Login() {
		System.out.println("created the login");
	}
	@Test(dependsOnMethods="Login") 
	public void logout() {
		System.out.println("logout was done");
	}
}

