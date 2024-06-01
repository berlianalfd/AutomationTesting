package WEB.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import WEB.pages.HomePage;
import WEB.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginTest {
    WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;

    @Given("I have opened the application in the browser")
    public void OpenBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @And("I have been navigated to the login page")
    public void navigateToLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("I enter username {string} and password {string}")
    public void enterCredentials(String username, String password) {
        loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("I click the login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should see the message {string} on the login form")
    public void verifyErrorMessage(String expectedErrorMessage) {
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Then("I should be redirected to the home page")
    public void verifyRedirectedToHomePage() {
        homePage = new HomePage(driver);
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @And("I should see the text {string} on the home page")
    public void verifyTextOnHomePage(String expectedText) {
        Assert.assertTrue(homePage.isProductTextDisplayed());
    }

    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
