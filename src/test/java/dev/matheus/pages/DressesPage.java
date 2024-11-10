package dev.matheus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import dev.matheus.Base.BasePage;

public class DressesPage extends BasePage {
    // Locator
    private By menuDressesLocator = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]");
    private By subMenuCasualDressesLocator = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[1]/a");
    private By titlePageCasualDressesLocator = By.xpath("//*[@id=\"center_column\"]/h1/span[1]");
    // Casual Dresses

    public DressesPage(WebDriver driver) {
        super(driver);
    }

    public void viewCasualDressesPage() {
        if (super.isDisplayed(menuDressesLocator)) {
            super.actionMoveToElement(menuDressesLocator);
            super.actionmoveToElementClickPerform(subMenuCasualDressesLocator);
        } else {
            System.out.println("Menu Dresses não está visível.");
        }
    }

    public String getTitlePageCasualDresses() {
        return super.getText(titlePageCasualDressesLocator);
    }

}
