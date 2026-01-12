package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

public class CheckoutPage extends BasePage{
	
	// -------- Xpaths --------
	
	//input[@id='billing_first_name']
	//input[@id='billing_last_name']
	//input[@id='billing_company']
	//span[@id='select2-billing_country-container']
	 //input[@role='combobox']
	//input[@id='billing_address_1']
	//input[@id='billing_address_2']
	//input[@id='billing_city']
	//span[@id='select2-billing_state-container']
	//input[@role='combobox']
	//input[@id='billing_postcode']
	//input[@id='billing_phone']
	//input[@id='billing_email']
	//input[@id='ship-to-different-address-checkbox']
	//textarea[@id='order_comments']
	//button[@id='place_order']
	
	//iframe["@class=razorpay-checkout-frame"]
	//*[@id="razorpay-checkout-v2-failed"]/div/button
	//*[@id="post-1291"]/div/div/p[1]
	
	// -------- Locators --------
	
	@FindBy(xpath="//input[@id='billing_first_name']")
	WebElement txt_first_name;
	
	@FindBy(xpath="//input[@id='billing_last_name']")
	WebElement txt_last_name;
	
	@FindBy(xpath="//input[@id='billing_company']")
	WebElement txt_billing_company;
	
	@FindBy(xpath="//span[@id='select2-billing_country-container']")
	WebElement select2_billing_country;
	
	@FindBy(xpath="//input[@role='combobox']")
	WebElement txt_billing_country;
	
	@FindBy(xpath="//input[@id='billing_address_1']")
	WebElement txt_billing_address_1;
	
	@FindBy(xpath="//input[@id='billing_address_2']")
	WebElement txt_billing_address_2;
	
	@FindBy(xpath="//input[@id='billing_city']")
	WebElement txt_billing_city;
	
	@FindBy(xpath="//span[@id='select2-billing_state-container']")
	WebElement select2_billing_state;
	
	@FindBy(xpath="//input[@role='combobox']")
	WebElement txt_billing_state;
	
	@FindBy(xpath="//input[@id='billing_postcode']")
	WebElement txt_billing_postcode;
	
	@FindBy(xpath="//input[@id='billing_phone']")
	WebElement txt_billing_phone;
	
	@FindBy(xpath="//input[@id='billing_email']")
	WebElement txt_billing_email;
	
	@FindBy(xpath="//input[@id='ship-to-different-address-checkbox']")
	WebElement chkbx_ship_to_different_address;
	
	@FindBy(xpath="//textarea[@id='order_comments']")
	WebElement txt_order_comments;	
	
	@FindBy(xpath="//button[@id='place_order']")
	WebElement btn_place_order;
	
	@FindBy(xpath = "//*[@id=\"razorpay-checkout-v2-failed\"]/div/div[2]/button")
	private WebElement btnCheckoutFailedClose;
	
	@FindBy(xpath = "//*[@id=\"post-1291\"]/div/div/p[1]")
	private WebElement txtOrderConfirmation;
	
	@FindBy(xpath = "//iframe[\"@class=razorpay-checkout-frame\"]")
	private WebElement razorpay_checkout_frame;
	
	// -------- Actions --------
	
	public void enterName(String firstname, String lastname)
	{
		type(txt_first_name, firstname);
		type(txt_last_name, lastname);
	}
	
	public void selectCountryAndState(String country, String state)
	{
		click(select2_billing_country);
		type(txt_billing_country, country);
		txt_billing_country.sendKeys(Keys.ENTER);
		
		
		click(select2_billing_state);
		type(txt_billing_state, state);
		txt_billing_state.sendKeys(Keys.ENTER);
		
	}
	
	
	public void enterBillingAddress(String company, 
									String houseNumber, 
									String appartment, 
									String city,  
									String pincode)
	{
		type(txt_billing_company, company);
		type(txt_billing_address_1, houseNumber);
		type(txt_billing_address_2, appartment);
		type(txt_billing_city, city);
		type(txt_billing_postcode, pincode);
		
		
	}
	
	public void enterContact(String phone, String email)
	{
		type(txt_billing_email, email);
		type(txt_billing_phone, phone);	
	}
	
	public void placeOrder()
	{
		if(chkbx_ship_to_different_address.isSelected())
			click(chkbx_ship_to_different_address);
		
		click(btn_place_order);
	}
	
	public void CheckoutFailedClose()
	{
		
		driver.switchTo().frame(razorpay_checkout_frame);
		if(btnCheckoutFailedClose.isDisplayed())
		click(btnCheckoutFailedClose);
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
	}
	
	public boolean orderConformation()
	{
		return isDisplayed(txtOrderConfirmation);
	}
}
