package dev.matheus.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().window().maximize();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void visit(String url) {
        this.driver.get(url);
    }

    public String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }

    public void quitWebDriver() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    protected WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void type(By locator, String text) {
        WebElement element = waitForElement(locator);
        element.clear(); // Limpa o campo antes de digitar
        element.sendKeys(text);
    }

    public void click(By locator) {
        WebElement element = waitForElement(locator);
        element.click();
    }

    public String getText(By locator) {
        return waitForElement(locator).getText();
    }

    public boolean isDisplayed(By locator) {
        try {
            return waitForElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
