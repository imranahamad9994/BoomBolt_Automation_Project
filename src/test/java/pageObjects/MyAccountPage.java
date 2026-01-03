package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

public class MyAccountPage extends BasePage{
		
//Elements For Register

	//input[@id='reg_username']
	//input[@id='reg_email']
	//input[@id='reg_password']
	//input[@name='register']
	
//Elements After Register
	//a[text()="Dashboard"]
	//a[text()="Logout"]
	
	
	//Locators
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement btn_register;
	
	@FindBy(xpath="//input[@id='reg_username']")
	WebElement txt_regUsername;
	
	@FindBy(xpath="//input[@id='reg_email']")
	WebElement txt_regEmail;
	
	@FindBy(xpath="//input[@id='reg_password']")
	WebElement txt_regPassword;
	
	@FindBy(xpath="//input[@name='register']")
	WebElement btn_registerr;
	
	@FindBy(xpath="//a[text()=\"Dashboard\"]")
	WebElement btn_dashboard;
	
	@FindBy(linkText="Logout")
	WebElement btn_Logout;
	
	@FindBy(xpath="//strong[normalize-space()='Error:']")
	WebElement regError;
	
	//Actions
	
	public void registerUser(String username, String email, String password)
	{
		click(btn_register);
		type(txt_regUsername, username);
		type(txt_regEmail, email);
		type(txt_regPassword, password);
		click(btn_registerr);
	}
	
	
	public boolean isRegistrationSuccessful()
	{
		return isDisplayed(btn_dashboard);
	}
	
	public boolean isRegistrationFailed()
	{
		return isDisplayed(regError);
	}
	
	
	public void logout()
	{
		click(btn_Logout);
	}
	
}
