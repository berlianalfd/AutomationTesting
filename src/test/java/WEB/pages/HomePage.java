package WEB.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
    private WebDriver driver;

    @FindBy(css = "#header_container > div.header_secondary_container > span")
    private WebElement productTextElement;

    @FindBy(id="inventory_container")
    private WebElement listProduct;

    @FindBy(id="add-to-cart-sauce-labs-backpack")
    private WebElement addToCartButton;

    @FindBy(id="remove-sauce-labs-backpack")
    private WebElement removeToCartButton;

    @FindBy(xpath = "//span[@data-test='shopping-cart-badge']")
    private WebElement notificationIconCart;

    @FindBy(id="item_4_title_link")
    private WebElement productName;

    @FindBy(id="item_4_img_link")
    private WebElement productImage;

    @FindBy(className = "shopping_cart_link")
    private WebElement iconCart;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isProductTextDisplayed() {
        WebElement productElement = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span"));
        return productElement.getText().contains("Products");
    }

    public boolean isListProductDisplayed() {
        return listProduct.isDisplayed();
    } 

    public void addToCartButton(){
        addToCartButton.click();
    }

    public String removeToCartButton(){
        return removeToCartButton.getText();
    }

    public String getNotificationOnTheCartIcon(){
        return notificationIconCart.getText();
    }

    public void clickProductName(){
        productName.click();
    }

    public void clickProductImage(){
        productImage.click();
    }

    public void clickIconCart() {
        iconCart.click();
    }
}


