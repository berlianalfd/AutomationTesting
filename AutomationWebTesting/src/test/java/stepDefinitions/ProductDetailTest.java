package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import pages.ProductDetailPage;
import pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;


public class ProductDetailTest {
    WebDriver driver;
    LoginPage loginPage;
    ProductDetailPage productDetailPage;

    @Given("I have launched the application")
    public void i_have_launched_the_application() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        loginPage = new LoginPage(driver);
    }

    @And("I have successfully logged in to the Swag Labs e-commerce application")
    public void i_have_successfully_logged_in_to_the_swag_labs_e_commerce_application() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }

    @And("I have navigated to the Product Detail page")
    public void i_have_navigated_to_the_product_detail_page() {
        WebElement productLink = driver.findElement(By.id("item_4_title_link"));
        productLink.click();
        productDetailPage = new ProductDetailPage(driver);
    }

    @Given("I have added the product to the cart")
    public void i_have_added_the_product_to_the_cart() {
        productDetailPage.clickAddToCartButton();
    }

    @And("the button is in the {string} state")
    public void the_button_is_in_the_state(String buttonState) {
        assert(productDetailPage.getAddToCartButtonText().equals(buttonState));
    }

    @When("I am on the Product Detail page which contains detailed information about a product including the product image, product name, product description, and product price")
    public void i_am_on_the_product_detail_page() {
        assert(productDetailPage.getProductName().equals("Sauce Labs Backpack"));
    }

    @When("I press the {string} button")
    public void i_press_the_button(String buttonName) {
        if (buttonName.equals("Add to cart")) {
            productDetailPage.clickAddToCartButton();
        } else if (buttonName.equals("Remove")) {
            productDetailPage.clickRemoveButton();
        }
    }

    @When("I press the Cart Icon located at the top right corner")
    public void i_press_the_cart_icon_located_at_the_top_right_corner() {
        productDetailPage.clickCartIcon();
    }

    @When("I press the Back to Product button")
    public void i_press_the_back_to_product_button() {
        productDetailPage.clickBackToProductButton();
    }


    @Then("the system displays the Product Detail page containing detailed information about a product including the product image, product name, product description, and product price")
    public void the_system_displays_the_product_detail_page() {
        assert(productDetailPage.isProductImageDisplayed());
        assert(productDetailPage.getProductName().equals("Sauce Labs Backpack"));
        assert(productDetailPage.getProductDescription().length() > 0);
        assert(productDetailPage.getProductPrice().equals("$29.99"));
    }

    @Then("the system successfully adds the product to my cart")
    public void the_system_successfully_adds_the_product_to_my_cart() {
        assert(productDetailPage.getCartBadgeText().equals("1"));
    }

    @And("the system changes the {string} button to {string}")
    public void the_system_changes_the_button_to(String oldButtonName, String newButtonName) {
        assert(productDetailPage.getAddToCartButtonText().equals(newButtonName));
    }

    @And("the system notifies me about the increase in the number of items in the cart on the Cart Icon")
    public void the_system_notifies_me_about_the_increase_in_the_number_of_items_in_the_cart_on_the_cart_icon() {
        assert(productDetailPage.getCartBadgeText().equals("1"));
    }

    @Then("the system successfully removes the product from my cart")
    public void the_system_successfully_removes_the_product_from_my_cart() {
        assert(productDetailPage.getCartBadgeText().isEmpty());
    }

    @And("the system notifies me about the decrease in the number of items in the cart on the Cart Icon")
    public void the_system_notifies_me_about_the_decrease_in_the_number_of_items_in_the_cart_on_the_cart_icon() {
        assert(productDetailPage.getCartBadgeText().isEmpty());
    }

    @Then("the system displays the Cart page containing the products I want to buy")
    public void the_system_displays_the_cart_page_containing_the_products_i_want_to_buy() {
        assert(productDetailPage.isCartPageDisplayed());
    }

    @Then("the system displays the dashboard page showing the list of product catalogs")
    public void the_system_displays_the_dashboard_page_showing_the_list_of_product_catalogs() {
        Assert.assertTrue("Dashboard page is not displayed", productDetailPage.isDashboardPageDisplayed());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

