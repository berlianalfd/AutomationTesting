package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.MenuPage;
import pages.AboutMenuPage;
import org.junit.Assert;
import static org.junit.Assert.assertTrue;

public class MenuTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private MenuPage menuPage;
    private HomePage homePage;
    private AboutMenuPage aboutMenuPage;

    @Given("I have launched the browser")
    public void iHaveLaunchedTheBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @And("I have launched the Swag Labs application")
    public void iHaveLaunchedTheSwagLabsApplication() {
        driver.get("https://www.saucedemo.com/");
    }

    @And("I have successfully logged in to the E-commerce application: Swag Labs")
    public void iHaveSuccessfullyLoggedInToTheECommerceApplicationSwagLabs() {
        loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        menuPage = new MenuPage(driver);
    }

    @And("I am on the dashboard page displaying a catalog of items that can be ordered by customers")
    public void iAmOnTheDashboardPageDisplayingACatalogOfItemsThatCanBeOrderedByCustomers() {
        assertTrue(menuPage.isMenuButtonDisplayed());
    }

    @When("I tap on the Menu icon available on the top left of the application")
    public void iTapOnTheMenuIconAvailableOnTheTopLeftNavigationBarOfTheApplication() {
        menuPage.clickMenuButton();
    }

    @Then("I should see a Bar containing a list of menus, including All Items, About, Logout, Reset App State")
    public void iShouldSeeABarContainingAListOfMenusIncludingAllItemsAboutLogoutResetAppState() {
        assertTrue("All Items menu is not displayed", menuPage.isAllItemsMenuDisplayed());
        assertTrue("About menu is not displayed", menuPage.isAboutMenuDisplayed());
        assertTrue("Logout menu is not displayed", menuPage.isLogoutMenuDisplayed());
        assertTrue("Reset App State menu is not displayed", menuPage.isResetAppMenuDisplayed());
    }

    @And("I should see a Bar containing a list of menus")
    public void iShouldSeeABarContainingAListOfMenus() {
        assertTrue("All Items menu is not displayed", menuPage.isAllItemsMenuDisplayed());
        assertTrue("About menu is not displayed", menuPage.isAboutMenuDisplayed());
        assertTrue("Logout menu is not displayed", menuPage.isLogoutMenuDisplayed());
        assertTrue("Reset App State menu is not displayed", menuPage.isResetAppMenuDisplayed());
    }

    @And("I tap on the {string} menu")
    public void iTapOnTheMenu(String menuName) {
        menuPage.clickMenuItem(menuName);
    }

    @Then("I should be navigated to the dashboard page displaying the product catalog")
    public void iShouldBeNavigatedToTheDashboardPageDisplayingTheProductCatalog() {
        homePage = new HomePage(driver);
        assertTrue(homePage.isListProductDisplayed());
    }

    @Then("I should be navigated to the page displaying information about the creators of Swag Labs")
    public void iShouldBeNavigatedToThePageDisplayingInformationAboutTheCreatorsOfSwagLabs() {
        aboutMenuPage = new AboutMenuPage(driver);
        assertTrue("About page is not displayed", aboutMenuPage.isAboutPageDisplayed());
    }

    @Then("I should be directed to the Login page that displays the Username and password fields as before")
    public void iShouldBeDirectedToTheLoginPageThatDisplaysTheUsernameAndPasswordFieldsAsBefore() {
        loginPage = new LoginPage(driver);
        loginPage.isFormLoginDisplayed();
        Assert.assertEquals("https://www.saucedemo.com/", driver.getCurrentUrl());
    }

    @Then("I should be navigated to the dashboard page displaying a new catalog of items that can be ordered by customers")
    public void iShouldBeNavigatedToTheDashboardPageDisplayingANewCatalogOfItemsThatCanBeOrderedByCustomers() {
        homePage = new HomePage(driver);
        assertTrue(homePage.isListProductDisplayed());
    }
    

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
