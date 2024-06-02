package WEB.stepDefinitions;

import WEB.pages.CartPage;
import WEB.pages.CheckoutPage;
import WEB.pages.HomePage;
import WEB.pages.LoginPage;
import WEB.pages.MenuPage;
import WEB.pages.ProductDetailPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.Assert.*;

import org.junit.Assert;

public class EndToEndTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private ProductDetailPage productDetailPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private MenuPage menuPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        productDetailPage = new ProductDetailPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        menuPage = new MenuPage(driver);
        driver.get("https://www.saucedemo.com/");
    }

    @Given("I launch the application and log in with username {string} and password {string}")
    public void i_launch_the_application_and_log_in_with_username_and_password(String username, String password) {
        assertTrue(loginPage.isFormLoginDisplayed());
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        assertTrue(homePage.isProductTextDisplayed());
    }

    @When("I select the product {string} and add it to the cart")
    public void i_select_the_product_and_add_it_to_the_cart(String productName) {
        WebElement productLink = driver.findElement(By.id("item_4_title_link"));
        productLink.click();
        productDetailPage = new ProductDetailPage(driver);
        productDetailPage.clickAddToCartButton();
    }

    @And("I proceed to the checkout page")
    public void i_proceed_to_the_checkout_page() {
        homePage.clickIconCart();
        assertTrue(cartPage.getTitleCartPage().contains("Your Cart"));
        cartPage.clickCheckoutButton();
        assertTrue(checkoutPage.checkoutInformainForm());
    }

    @And("I fill out the checkout form with first name {string}, last name {string}, and postal code {string}")
    public void i_fill_out_the_checkout_form_with_first_name_last_name_and_postal_code(String firstName, String lastName, String postalCode) {
        checkoutPage.enterFirstName(firstName);
        checkoutPage.enterLastName(lastName);
        checkoutPage.enterPostalCode(postalCode);
        checkoutPage.clickContinueButton();
        assertTrue(checkoutPage.isCheckoutOverviewPage());
    }

    @Then("I verify the checkout overview details: payment info {string}, sauce card {string}, shipping info {string}, delivery method {string}, and total price {string}")
    public void i_verify_the_checkout_overview_details(String paymentInfo, String sauceCard, String shippingInfo, String freePony, String priceTotal) {
        assertEquals(paymentInfo, checkoutPage.getPaymentInformationText());
        assertEquals(sauceCard, checkoutPage.getSauceCardText());
        assertEquals(shippingInfo, checkoutPage.getShippingInformationText());
        assertEquals(freePony, checkoutPage.getFreePonyText());
        assertEquals(priceTotal, checkoutPage.getPriceTotalText());
        assertTrue(checkoutPage.summaryInfo());
    }

    @And("I click the finish button to complete the order")
    public void i_click_the_finish_button_to_complete_the_order() {
        checkoutPage.clickFinishButton();
    }

    @And("I click the back home button for back to homepage")
    public void i_click_the_back_home_button_for_back_to_homepage() {
        checkoutPage.clickBackToHomePageButton();
    }

    @And("I click on Menu icon available on the top left of the application")
    public void IclickonMenuiconavailableonthetopleftoftheapplication() {
        menuPage.clickMenuButton();
    }

    @And("I should see a Bar containing a menus")
    public void iShouldSeeABarContainingAMenus() {
        assertTrue("All Items menu is not displayed", menuPage.isAllItemsMenuDisplayed());
        assertTrue("About menu is not displayed", menuPage.isAboutMenuDisplayed());
        assertTrue("Logout menu is not displayed", menuPage.isLogoutMenuDisplayed());
        assertTrue("Reset App State menu is not displayed", menuPage.isResetAppMenuDisplayed());
    }

    @And("I click the {string} menu")
    public void iClickTheMenu(String menuName) {
        menuPage.clickMenuItem(menuName);
    }

    @Then("I should be redirected to the login page with username and password fields displayed")
    public void i_should_be_redirected_to_the_login_page_with_username_and_password_fields_displayed() {
        loginPage = new LoginPage(driver);
        loginPage.isFormLoginDisplayed();
        Assert.assertEquals("https://www.saucedemo.com/", driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
