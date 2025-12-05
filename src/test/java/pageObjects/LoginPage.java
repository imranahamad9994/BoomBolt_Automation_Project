package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

public class LoginPage extends BasePage{

	//For Login
		//input[@id='username']
		//input[@id='password']
		//input[@id='rememberme']
		//a[normalize-space()='Lost your password?']
		//input[@name='login']
		
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//input[@id='username']")
	@CacheLookup
	WebElement txt_Username;
	
	
	@FindBy(xpath="//input[@id='password']")
	@CacheLookup
	WebElement txt_Password;
	
	@FindBy(xpath="//input[@name='login']")
	@CacheLookup
	WebElement btn_Login;
	
	@FindBy(linkText="Logout")
	@CacheLookup
	WebElement lnk_Logout;
	
	@FindBy(xpath="//a[text()=\"Dashboard\"]")
	@CacheLookup
	WebElement btn_dashboard;
	
	public void enterUsername(String username)
	{
		txt_Username.sendKeys(username)	;
	}
	
	public void enterPassword(String password)
	{
		txt_Password.sendKeys(password);
	}
	
	public void clickLogin()
	{
		btn_Login.click();
	}
	
	public boolean isDashboardVisible()
	{
		boolean dashboard = btn_dashboard.isDisplayed();
		return dashboard;
	}
	
	public void clickLogout()
	{
		lnk_Logout.click();
	}
	
}
