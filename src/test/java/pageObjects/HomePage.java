package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		 this.driver = BaseClass.driver.get();
		
	}
	
	@FindBy(xpath="//a[normalize-space()='My Account']")
	@CacheLookup
	WebElement link_myAccount;
	
	public void clickMyAccount()
	{
		link_myAccount.click();
	}	
}
