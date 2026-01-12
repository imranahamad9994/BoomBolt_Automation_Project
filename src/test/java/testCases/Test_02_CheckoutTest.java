package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pageObjects.BaseClass;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;

public class Test_02_CheckoutTest extends BaseClass {
	
	Faker faker;
	
	
	@Test
	public void testCheckout() throws InterruptedException
	{
		driver.get().navigate().to(p.getProperty("homeURL"));
		String indianPincode = "560001";
		
		HomePage home =new HomePage();
		home.clickPreOrder();
		
		faker = new Faker();
		CheckoutPage checkout = new CheckoutPage();
		
		checkout.enterName(faker.name().firstName(), faker.name().lastName());
		checkout.selectCountryAndState(p.getProperty("country"), p.getProperty("state"));
		checkout.enterBillingAddress(faker.company().name(), faker.address().buildingNumber(),faker.address().streetAddress(), faker.address().city(), indianPincode);
		checkout.enterContact(faker.phoneNumber().cellPhone(), faker.internet().emailAddress());
		checkout.placeOrder();
		
		System.out.println(driver.get().getTitle());
		
		//Thread.sleep(3000);
		
		checkout.CheckoutFailedClose();
		
		Assert.assertTrue(checkout.orderConformation(), "Order not placed");
		
		
	}

}
