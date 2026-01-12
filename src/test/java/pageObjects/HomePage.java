package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

public class HomePage extends BasePage {
	
	//div[normalize-space()='PRE-ORDER']
	
	@FindBy(xpath="//div[normalize-space()='PRE-ORDER']")
	List<WebElement> btn_preorder;
	
	public void clickPreOrder()
	{
		click(btn_preorder.get(0));
	}
}
