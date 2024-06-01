package WEB.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import WEB.pages.CartPage;
import WEB.pages.HomePage;
import WEB.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class CartTest {
    WebDriver driver;
    private CartPage cartPage;
    private LoginPage loginPage;
    private HomePage homePage;

    @Given("I have opened the browser.")
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @And("I have opened the Swag Labs application URL.")
    public void SwagLabsApplicationURL() {
        driver.get("https://www.saucedemo.com/");
    }

    @And("I have logged into the application with username with username {string} and password {string}.")
    public void loginToApliction(String username, String password) {
        loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    @And("I am on the Dashboard page")
    public void navigateToDashoardPage() {
        homePage = new HomePage(driver);
        homePage.isListProductDisplayed();
    }

    @When("I click on the cart icon")
    public void clickIconCart() {
        homePage.clickIconCart();
    }

    @Then("I am redirected to the cart page")
    public void verifyCartPage() {
        cartPage = new CartPage(driver);
        String actualURL = cartPage.getCartPageURL();
        Assert.assertEquals("https://www.saucedemo.com/cart.html", actualURL);
    }

    @And("I see the title {string}")
    public void verifyTitle(String expectedTitle) {
        String actualTitle = cartPage.getTitleCartPage();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @And("I see a button to continue shopping, namely {string}")
    public void buttonContinueShopping(String expected) {
        String actual = cartPage.getButtoContinueShopping();
        Assert.assertEquals(expected, actual);
    }

    @And("I see a button to checkout, namely {string}")
    public void buttonCheckout(String expected) {
        String actual = cartPage.getButtonCheckout();
        Assert.assertEquals(expected, actual);
    }

    @And("I have clicked on the cart icon on the Dashboard page")
    public void clickIconCartOnTheDashboardpage() {
        homePage.clickIconCart();
    }

    @And("I am on the cart page")
    public void verifiyCartPage() {
        cartPage = new CartPage(driver);
        String actualURL = cartPage.getCartPageURL();
        Assert.assertEquals("https://www.saucedemo.com/cart.html", actualURL);
    }

    @When("I click button Continue Shopping")
    public void clickButtonContinueShopping() {
       cartPage.clickContinueShoppingButton();
    }

    @Then("I am redirected to the dashboard page displaying the product catalog list")
    public void redirectedToDashboardPage() {
        homePage = new HomePage(driver);
        Assert.assertTrue("Home Page isn't displayed", homePage.isListProductDisplayed());
    }

    @And("I have added a product to the cart")
    public void addProductToCart() {
        homePage = new HomePage(driver);
        homePage.addToCartButton();
    }

    @When("I click the Checkout button")
    public void clickCheckoutButton() {
        cartPage.clickCheckoutButton();
    }

    // @Then("I am redirected to the checkout page displaying the checkout information form")
    // public void redirectedToCheckoutPage() {
        
    // }

    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
    
} 
