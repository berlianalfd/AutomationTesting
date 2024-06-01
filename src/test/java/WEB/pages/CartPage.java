package WEB.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private WebDriver driver;

    @FindBy(xpath = "//span[@data-test='title']")
    private WebElement titleCartPage;

    @FindBy(id="continue-shopping")
    private WebElement buttonContinueShopping;

    @FindBy(id="checkout")
    private WebElement buttonCheckout;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getCartPageURL() {
        return driver.getCurrentUrl();
    }

    public String getTitleCartPage(){
        return titleCartPage.getText();
    }

    public String getButtoContinueShopping(){
        return buttonContinueShopping.getText();
    }

    public String getButtonCheckout(){
        return buttonCheckout.getText();
    }

    public void clickContinueShoppingButton(){
        buttonContinueShopping.click();
    }

    public void clickCheckoutButton(){
        buttonCheckout.click();
    }
}
