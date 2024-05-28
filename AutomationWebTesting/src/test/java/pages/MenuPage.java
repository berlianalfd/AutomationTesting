package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage {
    private WebDriver driver;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;

    @FindBy(id = "inventory_sidebar_link")
    private WebElement allItemsMenu;

    @FindBy(id = "about_sidebar_link")
    private WebElement aboutMenu;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutMenu;

    @FindBy(id = "reset_sidebar_link")
    private WebElement resetAppMenu;

    public MenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickMenuButton() {
        menuButton.click();
    }

    public boolean isAllItemsMenuDisplayed() {
        return allItemsMenu.isDisplayed();
    }

    public boolean isAboutMenuDisplayed() {
        return aboutMenu.isDisplayed();
    }

    public boolean isLogoutMenuDisplayed() {
        return logoutMenu.isDisplayed();
    }

    public boolean isResetAppMenuDisplayed() {
        return resetAppMenu.isDisplayed();
    }

    public boolean isMenuButtonDisplayed() {
        return menuButton.isDisplayed();
    }
}
