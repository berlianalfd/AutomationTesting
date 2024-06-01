package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage {
    private WebDriver driver;

    @FindBy(className = "inventory_details_img")
    private WebElement productImage;

    @FindBy(className = "inventory_details_name")
    private WebElement productName;

    @FindBy(className = "inventory_details_desc")
    private WebElement productDescription;

    @FindBy(className = "inventory_details_price")
    private WebElement productPrice;

    @FindBy(css = "button.btn_inventory")
    private WebElement addToCartButton;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;

    @FindBy(className = "shopping_cart_container")
    private WebElement cartIcon;

    @FindBy(id = "back-to-products")
    private WebElement backToProductButton;

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isProductImageDisplayed() {
        return productImage.isDisplayed();
    }

    public boolean isProductNameDisplay(){
        return productName.isDisplayed();
    }

    public boolean isProductDescriptionDisplay(){
        return productDescription.isDisplayed();
    }

    public boolean isProductPriceDisplay(){
        return productPrice.isDisplayed();
    }

    public String getProductName() {
        return productName.getText();
    }

    public String getProductDescription() {
        return productDescription.getText();
    }

    public String getProductPrice() {
        return productPrice.getText();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public String getAddToCartButtonText() {
        return addToCartButton.getText();
    }

    public void clickCartIcon() {
        cartIcon.click();
    }
    
    public void clickBackToProductButton() {
        backToProductButton.click();
    }


    public void clickRemoveButton() {
        if (addToCartButton.getText().equals("Remove")) {
            addToCartButton.click();
        } else {
            System.out.println("Tombol Remove tidak tersedia.");
        }
    }

    public String getCartBadgeText() {
        try {
            return cartBadge.getText();
        } catch (Exception e) {
            System.out.println("Elemen cartBadge tidak ditemukan.");
            return "";
        }
    }

    public boolean isCartPageDisplayed() {
        return driver.getCurrentUrl().contains("cart.html");
    }

    public boolean isDashboardPageDisplayed() {
        return driver.getCurrentUrl().contains("inventory.html");    
    }
}
