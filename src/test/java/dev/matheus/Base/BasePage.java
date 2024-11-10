package dev.matheus.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public abstract class BasePage {
    private WebDriverWait waitElement;
    protected WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    private Select select;

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

    public void actionMoveToElement(By locator) {
        if (this.action == null) {
            this.action = new Actions(driver);
        }
        WebElement element = this.driver.findElement(locator);
        action.moveToElement(element).perform();
    }

    public void actionmoveToElementClickPerform(By locator) {
        if (this.action == null) {
            this.action = new Actions(driver);
        }
        WebElement element = this.driver.findElement(locator);
        action.moveToElement(element).click().build().perform();
    }

    public String getTextByAttribute(By locator, String attribute) {
        System.err.println("Retorno do value" + this.driver.findElement(locator).getAttribute(attribute));
        return this.driver.findElement(locator).getAttribute(attribute);
    }

    public void waitElement(By locator) {
        if (this.waitElement == null) {
            this.waitElement = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
        this.waitElement.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitElementToBeClickable(By locator) {
        if (this.waitElement == null) {
            this.waitElement = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
        this.waitElement.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitElementToBeSelected(By locator) {
        if (this.waitElement == null) {
            this.waitElement = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
        this.waitElement.until(ExpectedConditions.elementToBeSelected(locator));
    }

    public void selectByValue(By locator, String value) {
        select = new Select(this.driver.findElement(locator));
        select.selectByValue(value);
    }

}
