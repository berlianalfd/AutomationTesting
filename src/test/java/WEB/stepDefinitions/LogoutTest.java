package WEB.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import WEB.pages.HomePage;
import WEB.pages.LoginPage;
import WEB.pages.LogoutPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LogoutTest {
    WebDriver driver;
    private LoginPage loginPage;
    private LogoutPage logoutPage;
    private HomePage homePage;

    @Given("I have opened the web application in the browser")
    public void OpenBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @And("I successfully login to the E-commerce application: Swag Labs")
    public void successfullyLogin() {
        loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }

    @And("I am on the dashboard page that displays a list of catalogue items that can be ordered by customers")
    public void DashboardPage() {
        homePage = new HomePage(driver);
        homePage.isListProductDisplayed();
    }

    @When("I click the Menu navigation bar")
    public void MenuNavigationBar() {
        logoutPage = new LogoutPage(driver);
        logoutPage.clickNavBar();
    }

    @And("I click the Logout menu")
    public void LogoutAplication() {
        logoutPage.clickLogoutButton();
    }

    @Then("I should be directed to the Login page that displays the Username and password fields")
    public void verifyLogoutSuccess() {
        loginPage = new LoginPage(driver);
        loginPage.isFormLoginDisplayed();
        Assert.assertEquals("https://www.saucedemo.com/", driver.getCurrentUrl());
    }

    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

}
