package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.MyAccountPage;
import utilities.DataProviders;
@Test(dataProvider = "regData", dataProviderClass = DataProviders.class)
public class Test_01_RegistrationDDT extends BaseClass {
	
	
	
	public void testRegistrationDDT(String username, String email, String password)
	{
		try {
			
		
		MyAccountPage map = new MyAccountPage(driver);
		
//		String username= randomString();
//		String email = randomString()+"@aol.in";
//		String password = randomAlphaNumeric();
		
		System.out.println(username+"\t"+email+"\t"+password);
		
		map.clickRegister1();
		
		map.clearUsername();
		map.enterUsername(username);
		
		map.clearEmail();
		map.enterEmail(email);
		
		map.clearPassword();
		map.enterPassword(password);
		
		map.clickRegister2();
		
		boolean dashboard_visibility = map.isDashboardVisible();
		
		map.clickLogout();
		driver.navigate().to(URL);
		Assert.assertTrue(dashboard_visibility);
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			Assert.fail();
		}
		
		
		
	}
}
