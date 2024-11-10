package dev.matheus.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.matheus.pages.RegisterPage;

public class RegisterPageTest {
    private WebDriver driver;
    private RegisterPage registerPage;
    private String emailCreate = "matheus2052@gmail.com";

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        registerPage = new RegisterPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testRegisterNewAccount() {
        registerPage.visit("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
        registerPage.insertEmailToRegister(emailCreate);
        assertTrue(registerPage.getEmailNewAccountString().contains(emailCreate));

        registerPage.clickGenderMrs();
        registerPage.insertFirstName("Matheus");
        registerPage.insertLastName("Santos");
        registerPage.insertPassword("123456");
        registerPage.selectDateBirth("1", "12", "1997");
        registerPage.clickSubmitAccount();
        assertTrue(registerPage.getNameHeader().contains("Matheus Santos"));

    }
}
