package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pageObjects.BaseClass;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;


public class Test_01_RegistrationTest extends BaseClass{
	
	Faker faker;
	 @Test(description = "Verify user can register with valid details",
		   groups = {"registration", "smoke"})
	public void register_with_valid_details_should_create_new_user()
	{
		 // Ensure correct starting page
	        driver.get().get(p.getProperty("appURL"));
	        
		faker = new Faker();
		MyAccountPage map = new MyAccountPage();
		
		String username = faker.name().username();
		String email = faker.internet().emailAddress();
		String password = faker.internet().password();
		
		map.registerUser(username, email, password);
		boolean regSuccess = map.isRegistrationSuccessful();
		Assert.assertTrue(regSuccess, "Registration Failed for:"+username);
		
		if(regSuccess)
			map.logout();
	}

}
