package dev.matheus.tests;

import dev.matheus.pages.LoginPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private final String URL = "http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";
    private final String VALID_EMAIL = "matheus2050@gmail.com";
    private final String VALID_PASSWORD = "matheus123";

 /*    @BeforeAll
    public void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    } */

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        loginPage.visit(URL);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLoginWithValidCredentials() {
        loginPage.signin(VALID_EMAIL, VALID_PASSWORD);

        // Verifique se a mensagem "My account" aparece
        assertTrue(
                loginPage.isLoginSuccessful(),
                "Falha no login: Esperado que a mensagem 'My account' esteja visível após o login bem-sucedido.");
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        loginPage.signin("invalid_email@gmail.com", "wrong_password");

        // Verifique se a mensagem de erro é exibida
        assertTrue(
                loginPage.getCurrentUrl().contains("authentication"),
                "Falha ao verificar login inválido: A URL não está correta, o que indica que o login foi aceito indevidamente.");
    }
}
