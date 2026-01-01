package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;


public class Test_01_RegistrationTest extends BaseClass{
	
	@Test
	public void testRegistration()
	{
		try {
			
//			HomePage hp = new HomePage(driver);
//			hp.clickMyAccount();
			
		
		//MyAccountPage map = new MyAccountPage(driver);
		MyAccountPage map = new MyAccountPage(driver.get());//With ThreadLocal
		
		String username= randomString();
		String email = randomString()+"@aol.in";
		String password = randomAlphaNumeric();
		
		System.out.println(username+"\t"+email+"\t"+password);
		
		map.clickRegister1();
		map.enterUsername(username);
		map.enterEmail(email);
		map.enterPassword(password);
		map.clickRegister2();
		
		boolean dashboard_visibility = map.isDashboardVisible();
		map.clickLogout();
		//driver.navigate().to(URL);
		driver.get().navigate().to(URL);//With ThreadLocal
		Assert.assertTrue(dashboard_visibility);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			Assert.fail();
		}
		
		
		
	}

}
