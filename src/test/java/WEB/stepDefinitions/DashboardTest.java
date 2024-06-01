package WEB.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import WEB.pages.HomePage;
import WEB.pages.LoginPage;
import WEB.pages.ProductDetailPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class DashboardTest {
    WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private ProductDetailPage productDetailPage;

    @Given("I have opened the browser")
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @And("I have opened the Swag Labs application URL")
    public void SwagLabsApplicationURL() {
        driver.get("https://www.saucedemo.com/");
    }

    @And("I have logged into the application with username with username {string} and password {string}")
    public void loginToApliction(String username, String password) {
        loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    @And("I am on the Dashboard page displaying the product catalog list")
    public void navigateToDashoardPage() {
        homePage = new HomePage(driver);
        homePage.isListProductDisplayed();
    }

    @When("I click Add to cart button on the selected product in the product catalog list")
    public void clickAddToCartButton() {
        homePage.addToCartButton();
    }

    @Then("I received a notification about an increase in the number of items that amounted to {string} on the cart icon for the selected product added to the cart")
    public void notificationOnTheCartIcon(String sum) {
        String actual = homePage.getNotificationOnTheCartIcon();
        Assert.assertEquals(sum, actual);
    }

    @Then("the Add to cart button changes to Remove")
    public void verifyButton() {
        String actual = homePage.removeToCartButton();
        Assert.assertEquals("Remove", actual);
    }

    @When("I click on the product name in the product catalog list")
    public void ClickProductName() {
        homePage.clickProductName();
    }

    @When("I click on a product image in the product catalog list")
    public void clickProductImage() {
        homePage.clickProductImage();
    }

    @Then("I am redirected to the Product Detail page which contains more detailed information about the product including the product image, product name, product description, and product price")
    public void verifyProducTDetailPage() {
        productDetailPage = new ProductDetailPage(driver);
        Assert.assertTrue("Product image isn't displayed", productDetailPage.isProductImageDisplayed());
        Assert.assertTrue("Product name isn't displayed", productDetailPage.isProductImageDisplayed());
        Assert.assertTrue("Product description isn't displayed", productDetailPage.isProductDescriptionDisplay());
        Assert.assertTrue("Product price isn't displayed", productDetailPage.isProductPriceDisplay());
    }

    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
