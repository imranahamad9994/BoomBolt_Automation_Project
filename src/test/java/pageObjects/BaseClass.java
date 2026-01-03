package pageObjects;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	//public WebDriver driver;
	// ✅ Thread-safe WebDriver for parallel execution
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public String URL = "https://boombolt.in/my-account/";
	public Properties p;

	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException
	{
		FileReader file = new FileReader(System.getProperty("user.dir") + "/src/test/resources/config.properties");
		p = new Properties();
		p.load(file);

		switch (br.toLowerCase())
		{
			case "chrome":
				
				if(p.get("headless").equals("true"))
				{
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--headless=new");
					driver.set(new ChromeDriver(options));
					break;
				}
				else
				{
				WebDriverManager.chromedriver().setup();
				//driver = new ChromeDriver();
				driver.set(new ChromeDriver());
				break;
				}
				
			case "edge":
				WebDriverManager.edgedriver().setup();
				//driver = new EdgeDriver();
				driver.set(new EdgeDriver());
				break;

			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				//driver = new FirefoxDriver();
				driver.set(new FirefoxDriver());
				break;

			default:
				System.out.println("Invalid Browser");
				return;
		}

		//driver.get(URL);
		driver.get().get(URL);

		//driver.manage().window().maximize();
		driver.get().manage().window().maximize();

		//driver.manage().deleteAllCookies();
		driver.get().manage().deleteAllCookies();

		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
	}

	@AfterClass
	public void tearDown()
	{
		if (driver.get() != null)
		{
			driver.get().quit();   // ✅ closes all browser windows
			driver.remove();       // ✅ VERY IMPORTANT for ThreadLocal cleanup
		}
	}

	// ================= Utility Methods =================

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
		return (GeneratedString + GeneratedNumber);
	}

	/*public String captureScreen(String testName) throws IOException {

	    // Create timestamp to make screenshot name unique
	    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

	    // ❌ TakesScreenshot ts = (TakesScreenshot) driver;
	    // ✅ Correct way with ThreadLocal
	    TakesScreenshot ts = (TakesScreenshot) driver.get();

	    File source = ts.getScreenshotAs(OutputType.FILE);

	    // Define destination file path
	    String destination = System.getProperty("user.dir") +
	    		"\\screenshots\\" + testName + "_" + timestamp + ".png";

	    // Create folder if not exists
	    new File(System.getProperty("user.dir") + "\\screenshots\\").mkdirs();

	    // Copy file to destination
	    File finalDestination = new File(destination);
	    FileUtils.copyFile(source, finalDestination);

	    // Return path for Extent Report
	    return destination;
	}*/
	//=====================Screenshot Method=============================
	
	public static String captureScreenStatic(String testName) throws IOException {
	    TakesScreenshot ts = (TakesScreenshot) driver.get();
	    File source = ts.getScreenshotAs(OutputType.FILE);

	    String destination = System.getProperty("user.dir")
	            + "/screenshots/" + testName + ".png";

	    FileUtils.copyFile(source, new File(destination));
	    return destination;
	}

}
