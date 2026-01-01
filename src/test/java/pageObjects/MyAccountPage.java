package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		 this.driver = BaseClass.driver.get();
		
	}
	


	
//For Register

	//input[@id='reg_username']
	//input[@id='reg_email']
	//input[@id='reg_password']
	//input[@name='register']
	
//AfterRegister
	//a[text()="Dashboard"]
	//a[text()="Logout"]
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	@CacheLookup
	WebElement btn_register;
	
	@FindBy(xpath="//input[@id='reg_username']")
	@CacheLookup
	WebElement txt_regUsername;
	
	@FindBy(xpath="//input[@id='reg_email']")
	@CacheLookup
	WebElement txt_regEmail;
	
	@FindBy(xpath="//input[@id='reg_password']")
	@CacheLookup
	WebElement txt_regPassword;
	
	@FindBy(xpath="//input[@name='register']")
	@CacheLookup
	WebElement btn_registerr;
	
	@FindBy(xpath="//a[text()=\"Dashboard\"]")
	@CacheLookup
	WebElement btn_dashboard;
	
	@FindBy(linkText="Logout")
	@CacheLookup
	WebElement btn_Logout;
	
	
	public void clickRegister1()
	{
		btn_register.click();
	}
	
	public void enterUsername(String username)
	{
		txt_regUsername.sendKeys(username)	;
	}
	
	public void enterEmail(String email)
	{
		txt_regEmail.sendKeys(email);
	}
	
	public void enterPassword(String password)
	{
		txt_regPassword.sendKeys(password);
	}
	
	public void clickRegister2()
	{
		btn_registerr.click();
	}
	
	public boolean isDashboardVisible()
	{
		boolean dashboard = btn_dashboard.isDisplayed();
		return dashboard;
	}
	
	public void clickLogout()
	{
		btn_Logout.click();
	}
	 
	public void clearUsername()
	{
		txt_regUsername.clear();
	}
	
	public void clearEmail()
	{
		txt_regEmail.clear();
	}
	
	public void clearPassword()
	{
		txt_regPassword.clear();
	}
}
