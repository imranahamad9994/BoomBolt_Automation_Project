package pageObjects;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public WebDriver driver;
	public String URL = "https://boombolt.in/my-account/";
	public Properties p;
	
	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException
	{
		FileReader file = new FileReader("C:\\Users\\Hp\\BoomBolt_Automation\\BoomBolt_Automation_Project\\src\\test\\resources\\config.properties");
		p=new Properties();
		p.load(file);
	
		
		switch(br.toLowerCase())
		{
		case "chrome" : driver = new ChromeDriver(); break;
		case "edge" : driver = new EdgeDriver();break;
		case "firefox" : driver = new FirefoxDriver();break;
		default : System.out.println("Invalid Browser"); return;
		}
		
		
		
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
	
	
	public String randomString()
	{
		String GeneratedString = RandomStringUtils.randomAlphabetic(5);
		return GeneratedString;
	}
	
	public String randomNumber()
	{
		String GeneratedNumber = RandomStringUtils.randomNumeric(10);
		return GeneratedNumber;
	}
	
	public String randomAlphaNumeric()
	{
		String GeneratedString = RandomStringUtils.randomAlphabetic(5);
		String GeneratedNumber = RandomStringUtils.randomNumeric(10);
		return (GeneratedString+GeneratedNumber);
	}
}
