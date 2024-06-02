package WEB.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    private WebDriver driver;

    @FindBy(id = "first-name")
    private WebElement firstNameField;

    @FindBy(id = "last-name")
    private WebElement lastNameField;

    @FindBy(id = "postal-code")
    private WebElement postalCodeField;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@data-test='payment-info-label']")
    private WebElement paymentInformationText;

    @FindBy(xpath = "//div[@data-test='payment-info-value']")
    private WebElement sauceCardText;
   
    @FindBy(xpath = "//div[@data-test='shipping-info-label']")
    private WebElement shippingInformationText;
    
    @FindBy(xpath = "//div[@data-test='shipping-info-value']")
    private WebElement freePonyText;
    
    @FindBy(xpath = "//div[@data-test='total-info-label']")
    private WebElement priceTotalText;
    
    @FindBy(id = "cancel")
    private WebElement cancelButton;

    @FindBy(xpath = "//div[@class='cart_contents_container']")
    private WebElement cartItemList;

    @FindBy(className = "summary_info")
    private WebElement summaryInfo;

    @FindBy(className ="checkout_info")
    private WebElement checkoutInformationForm;

    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(id = "back-to-products")
    private WebElement backToHomePageButton;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void enterPostalCode(String postalCode) {
        postalCodeField.sendKeys(postalCode);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void clickFinishButton() {
        finishButton.click();
    }

    public void clickBackToHomePageButton() {
        backToHomePageButton.click();
    }
    
    public boolean isCheckoutOverviewPage() {
        return driver.getCurrentUrl().contains("checkout-step-two.html");
    }

    public String getPaymentInformationText() {
        return paymentInformationText.getText();
    }

    public String getSauceCardText() {
        return sauceCardText.getText();
    }

    public String getShippingInformationText() {
        return shippingInformationText.getText();
    }

    public String getFreePonyText() {
        return freePonyText.getText();
    }

    public String getPriceTotalText() {
        return priceTotalText.getText();
    }

    public void clickCancelButton() {
        cancelButton.click();
    }
    
    public boolean isCartPage() {
        return driver.getCurrentUrl().contains("cart.html");
    }
    
    public boolean isItemDisplayed() {
        return cartItemList.isDisplayed();
    }

    public boolean summaryInfo(){
        return summaryInfo.isDisplayed();
    }

    public boolean checkoutInformainForm(){
        return checkoutInformationForm.isDisplayed();
    }
}

