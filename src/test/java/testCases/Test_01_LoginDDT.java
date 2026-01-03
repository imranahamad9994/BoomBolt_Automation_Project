package testCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.BaseClass;
import utilities.DataProviders;

@Listeners(utilities.ExtentReportManager.class)
public class Test_01_LoginDDT extends BaseClass {

    @Test(
        dataProvider = "LoginData",
        dataProviderClass = DataProviders.class,
        description = "Verify login functionality with multiple credentials",
        groups = {"login", "ddt", "regression"}
    )
    public void test_login_ddt(String username, String email, String password, String expectedResultForReg ) {
    	
    	// ✅ Ensure correct starting page for EVERY iteration
        driver.get().get(p.getProperty("appURL"));

        LoginPage loginPage = new LoginPage();

        loginPage.login(username, password);

        boolean isLoginSuccessful = loginPage.isDashboardDisplayed();

        // Assertion with meaningful message
        Assert.assertTrue(
                isLoginSuccessful,
                "Login failed for user: " + username
        );

        // IMPORTANT: cleanup for next iteration
        if (isLoginSuccessful) {
            loginPage.logout();
        }
    }
}
