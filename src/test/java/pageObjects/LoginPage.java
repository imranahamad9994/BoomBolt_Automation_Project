package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

public class LoginPage extends BasePage {

    // Locators
    @FindBy(id = "username")
    private WebElement txtUsername;

    @FindBy(id = "password")
    private WebElement txtPassword;

    @FindBy(name = "login")
    private WebElement btnLogin;

    @FindBy(xpath = "//a[text()='Dashboard']")
    private WebElement dashboardLink;

    @FindBy(linkText = "Logout")
    private WebElement lnkLogout;

    // Actions
    public void login(String username, String password) {
        type(txtUsername, username);
        type(txtPassword, password);
        click(btnLogin);
    }

    public boolean isDashboardDisplayed() {
        return isDisplayed(dashboardLink);
    }

    public void logout() {
        click(lnkLogout);
    }
}
