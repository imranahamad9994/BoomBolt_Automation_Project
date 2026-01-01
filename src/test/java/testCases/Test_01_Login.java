package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.BaseClass;

public class Test_01_Login extends BaseClass {

    @Test
    public void test_login_valid_credentials() {

        LoginPage loginPage = new LoginPage();

        loginPage.login(
                p.getProperty("username"),
                p.getProperty("password")
        );

        Assert.assertTrue(
                loginPage.isDashboardDisplayed(),
                "Dashboard is not visible after login"
        );

        loginPage.logout();
    }
}
