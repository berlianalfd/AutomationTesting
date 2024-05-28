package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.MenuPage;
import static org.junit.Assert.assertTrue;

public class MenuTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private MenuPage menuPage;

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
        menuPage = new MenuPage(driver);
        menuPage.clickMenuButton();
    }

    @Then("I should see a Bar containing a list of menus, including All Items, About, Logout, Reset App State")
    public void iShouldSeeABarContainingAListOfMenusIncludingAllItemsAboutLogoutResetAppState() {
        assertTrue("All Items menu is not displayed", menuPage.isAllItemsMenuDisplayed());
        assertTrue("About menu is not displayed", menuPage.isAboutMenuDisplayed());
        assertTrue("Logout menu is not displayed", menuPage.isLogoutMenuDisplayed());
        assertTrue("Reset App State menu is not displayed", menuPage.isResetAppMenuDisplayed());
    }

    // Add other steps definitions as needed

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // @And("I have been navigated to the login page")
    // public void userNavigatedToLoginPage() {
    //     driver.get("https://www.saucedemo.com/");
    // }

    // @And("I successfully logged in to the Swag Labs application")
    // public void userHasSuccessfullyLoggedInToTheSwagLabsApplication() {
    //     loginPage.enterUsername("standard_user");
    //     loginPage.enterPassword("secret_sauce");
    //     loginPage.clickLoginButton();
    //     menuPage = new MenuPage(driver);
    // }

    // @And("I on the dashboard page displaying the list of catalog items")
    // public void userIsOnTheDashboardPageDisplayingTheListOfCatalogItems() {
    //     assertTrue(menuPage.isMenuButtonDisplayed());
    // }

    // @When("I click on the Menu icon located at the top left \\(Navigation Bar)")
    // public void userClicksOnTheMenuIconLocatedAtTheTopLeftNavigationBar() {
    //     menuPage.clickMenuButton();
    // }

    // @Then("I should see a Bar containing a list of menu options")
    // public void userShouldSeeABarContainingAListOfMenuOptions() {
    //     assertTrue(menuPage.isAllItemsMenuDisplayed());
    //     assertTrue(menuPage.isAboutMenuDisplayed());
    //     assertTrue(menuPage.isLogoutMenuDisplayed());
    //     assertTrue(menuPage.isResetAppMenuDisplayed());
    // }

    // @And("the Bar should display the following menu options: All Items, About, Logout, Reset App State")
    // public void theBarShouldDisplayTheFollowingMenuOptions() {
    //     assertTrue(menuPage.isAllItemsMenuDisplayed());
    //     assertTrue(menuPage.isAboutMenuDisplayed());
    //     assertTrue(menuPage.isLogoutMenuDisplayed());
    //     assertTrue(menuPage.isResetAppMenuDisplayed());
    // }

    // @After
    // public void closeBrowser() {
    //     if (driver != null) {
    //         driver.quit();
    //     }
    // }
}
