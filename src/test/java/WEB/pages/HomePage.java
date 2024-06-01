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

}

