package dev.matheus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import dev.matheus.Base.BasePage;

public class RegisterPage extends BasePage {
    // Locators
    private By emailCreateLocator = By.id("email_create");
    private By submitCreateLocator = By.id("SubmitCreate");
    private By accountLocator = By.xpath("//h1[text()='Create an account']");
    private By emailLocator = By.id("email");
    private By checkNewsLettByLocator = By.id("uniform-newsletter");
    private By radioGenderMrLocator = By.id("uniform-id_gender1");
    private By radioGenderMrsLocator = By.id("uniform-id_gender2");
    private By firstNameLocator = By.id("customer_firstname");
    private By lastNameLocator = By.id("customer_lastname");
    private By passwordLocator = By.id("passwd");
    private By dayBirthLocator = By.id("days");
    private By monthBirthLocator = By.id("months");
    private By yearBirthLocator = By.id("years");
    private By submitAccountLocator = By.id("submitAccount");
    private By nameHeaderLocator = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void visit(String url) {
        driver.get(url);
    }

    public void insertEmailToRegister(String email) {
        if (super.isDisplayed(emailCreateLocator)) {
            super.type(emailCreateLocator, email);
            super.click(submitCreateLocator);
        } else {
            System.out.println("Elemento não encontrado");
        }
    }

    public String getEmailNewAccountString() {
        super.waitElement(this.checkNewsLettByLocator);
        return super.getTextByAttribute(this.emailLocator, "value");
    }

    public void clickGender() {
        super.click(radioGenderMrLocator);
    }

    public void clickGenderMrs() {
        super.click(radioGenderMrsLocator);
    }

    public void insertFirstName(String firstName) {
        super.type(firstNameLocator, firstName);
    }

    public void insertLastName(String lastName) {
        super.type(lastNameLocator, lastName);
    }

    public void insertPassword(String password) {
        super.type(passwordLocator, password);
    }

    public void selectDateBirth(String day, String month, String year) {
        super.selectByValue(dayBirthLocator, day);
        super.selectByValue(monthBirthLocator, month);
        super.selectByValue(yearBirthLocator, year);
    }

    public void clickSubmitAccount() {
        super.click(submitAccountLocator);
    }

    public String getNameHeader() {
        return super.getText(nameHeaderLocator);
    }
}
