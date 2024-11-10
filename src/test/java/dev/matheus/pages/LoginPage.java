package dev.matheus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import dev.matheus.Base.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private By emailAddressLocator = By.id("email");
    private By passwordLocator = By.id("passwd");
    private By signInLocator = By.id("SubmitLogin");
    private By tagMyAccountLocator = By.xpath("//h1[text()='My account']");

    public void signin(String email, String password) {
        if (super.isDisplayed(emailAddressLocator)) {
            super.type(emailAddressLocator, email);
            super.type(passwordLocator, password);
            super.click(signInLocator);
        }
    }

    public String getMyAccountMessage() {
        return super.getText(tagMyAccountLocator);
    }

    public boolean isLoginSuccessful() {
        return isDisplayed(tagMyAccountLocator);
    }
}
