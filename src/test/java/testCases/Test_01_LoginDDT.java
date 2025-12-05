package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.LoginPage;
import utilities.DataProviders;

public class Test_01_LoginDDT extends BaseClass {
	
	@Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
	void test_loginDDT(String username, String email, String password)
	{
	
	try {
		
		LoginPage lp = new LoginPage(driver);
		
		lp.enterUsername(email);
		lp.enterPassword(password);
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
	finally
	{
		driver.navigate().to(URL);
	}
	
	}

}
