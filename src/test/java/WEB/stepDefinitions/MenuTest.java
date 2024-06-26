package WEB.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import WEB.pages.HomePage;
import WEB.pages.LoginPage;
import WEB.pages.MenuPage;
import WEB.pages.AboutMenuPage;
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
