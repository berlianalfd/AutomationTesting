package WEB.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutMenuPage {
    private WebDriver driver;

    private By aboutPageUniqueElement = By.cssSelector("img[alt='Saucelabs']");

    public AboutMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAboutPageDisplayed() {
        return driver.findElement(aboutPageUniqueElement).isDisplayed();
    }
}

