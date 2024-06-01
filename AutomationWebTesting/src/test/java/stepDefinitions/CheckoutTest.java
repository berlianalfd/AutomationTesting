package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.CheckoutPage;
import pages.LoginPage;

public class CheckoutTest {
    WebDriver driver;
    CheckoutPage checkoutPage;
    LoginPage loginPage;

    @Given("I have opened the Swag Labs application in the browser")
    public void OpenBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        checkoutPage = new CheckoutPage(driver);
    }

    @And("I have logged in to the Swag Labs application with username with username {string} and password {string}")
    public void I_have_logged_in_to_the_Swag_Labs_application_with_username_with_username_and_password(String username, String password) {
        loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }
  
    @And("I am on the Checkout: Your Information page displaying the First Name, Last Name, and Zip or Postal Code fields")
    public void I_am_on_the_Checkout_Your_Information_page_displaying_the_First_Name_Last_Name_and_Zip_or_Postal_Code_fields() {
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
    }

    @When("I enter {string} in the First Name field")
    public void I_enter_in_the_First_Name_field(String firstName) {
        checkoutPage.enterFirstName(firstName);
    }

    @And("I enter {string} in the Last Name field")
    public void I_enter_in_the_Last_Name_field(String lastName) {
        checkoutPage.enterLastName(lastName);
    } 

    @And("I enter {string} in the Zip or Postal Code field")
    public void I_enter_in_the_Zip_or_Postal_Code_field(String postalCode) {
        checkoutPage.enterPostalCode(postalCode);
    }
    
    @And("I click the continue button")
    public void I_click_the_continue_button() {
        checkoutPage.clickContinueButton();
    }

    @Then("I should be navigated to the Checkout: Overview page")
    public void I_should_be_navigated_to_the_Checkout_Overview_page() {
        Assert.assertTrue(checkoutPage.isCheckoutOverviewPage());
    }

    @And("I should see the text about Payment Information is {string}")
    public void I_should_see_the_text_about_Payment_Information_is(String paymentInformation) {
        Assert.assertEquals(paymentInformation, checkoutPage.getPaymentInformationText());
    }
    
    @And("I should see the text about SauceCard is {string}")
    public void I_should_see_the_text_about_SauceCard_is(String sauceCard) {
        Assert.assertEquals(sauceCard, checkoutPage.getSauceCardText());
    }

    @And("I should see the text about Shipping Information is {string}")
    public void I_should_see_the_text_about_Shipping_Information_is(String shippingInformation) {
        Assert.assertEquals(shippingInformation, checkoutPage.getShippingInformationText());
    }

    @And("I should see the text about Free Pony Express Delivery is {string}")
    public void I_should_see_the_text_about_Free_Pony_Express_Delivery_is(String freePony) {
        Assert.assertEquals(freePony, checkoutPage.getFreePonyText());
    }

    @And("I should see the text about Price Total is {string}")
    public void I_should_see_the_text_about_Price_Total_is(String priceTotal) {
        Assert.assertEquals(priceTotal, checkoutPage.getPriceTotalText());
    }

    @Then("I should see summary info")
    public void showSummaryInfo() {
        Assert.assertTrue("summary info isn't displayed", checkoutPage.summaryInfo());
    }


    @When("I click the cancel button")
    public void I_click_the_cancel_button() {
        checkoutPage.clickCancelButton();
    }

    @Then("I should be redirected to the cart page")
    public void I_should_be_redirected_to_the_cart_page() {
        Assert.assertTrue(checkoutPage.isCartPage());
    }

    @Then("I should see the items I intend to purchase")
    public void I_should_see_the_items_I_intend_to_purchase() {
        Assert.assertTrue(checkoutPage.isItemDisplayed());
    }
    
    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
