package dev.matheus.tests;

import dev.matheus.pages.DressesPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DressesPageTest {
    private WebDriver driver;
    private DressesPage dressesPage;
    private final String URL = "http://www.automationpractice.pl/index.php";

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        dressesPage = new DressesPage(driver);
        dressesPage.visit(URL);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void accessDressPage() {
        dressesPage.viewCasualDressesPage();

        Assertions.assertEquals("CASUAL DRESSES ", dressesPage.getTitlePageCasualDresses(),
                "Falha ao verificar a página de vestidos casuais: O título não corresponde ao esperado.");
        Assertions.assertFalse(this.URL.equals(dressesPage.getCurrentUrl()),
                "Falha ao verificar a página de vestidos casuais: A URL não corresponde ao esperado.");
    }
}
