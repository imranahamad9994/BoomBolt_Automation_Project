package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.MyAccountPage;
import utilities.DataProviders;



public class Test_01_RegistrationDDT extends BaseClass {
	
	@Test(dataProvider = "RegistrationData", dataProviderClass = DataProviders.class,
			groups = {"DataDriven"},
			description = "Verify registration with valid, invalid and duplicate data")
	
	public void testRegistrationDDT(String username, String email, String password, String expectedResultForReg)
	{
		// Ensure correct starting page
        driver.get().get(p.getProperty("appURL"));
        
	
	MyAccountPage map = new MyAccountPage();
	
	map.registerUser(username, email, password);
	boolean regSuccess = map.isRegistrationSuccessful();
	boolean regFailure = map.isRegistrationFailed();
	
	if(expectedResultForReg.equalsIgnoreCase("success"))
	{
	Assert.assertTrue(regSuccess, "Expected SUCCESS but registration failed for email:" + email);
		map.logout();
	}
	
	else if(expectedResultForReg.equalsIgnoreCase("duplicate") || expectedResultForReg.equalsIgnoreCase("failure"))
			{
			Assert.assertTrue(regFailure, "Expected FAILURE but registration succeeded for email:" + email );
			}
	}
}

