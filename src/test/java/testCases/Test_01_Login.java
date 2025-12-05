package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.LoginPage;

public class Test_01_Login extends BaseClass {
	
	@Test
	void test_login()
	{
	
	try {
		
		LoginPage lp = new LoginPage(driver);
		
		lp.enterUsername(p.getProperty("username"));
		lp.enterPassword(p.getProperty("password"));
		lp.clickLogin();
		
		boolean dashboard = lp.isDashboardVisible();
		lp.clickLogout();
		Assert.assertTrue(dashboard);
		
		
		}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
		Assert.fail();
	}
	
	}
	
	
	
}
