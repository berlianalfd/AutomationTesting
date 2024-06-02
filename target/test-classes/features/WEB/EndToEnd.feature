Feature: End-to-end test from login to logout with successful checkout

  @TC0.6.1
  Scenario: Successful end-to-end flow from login to logout with checkout
    Given I launch the application and log in with username "standard_user" and password "secret_sauce"
    When I select the product "Sauce Labs Backpack" and add it to the cart
    And I proceed to the checkout page
    And I fill out the checkout form with first name "Lebron", last name "James", and postal code "40121"
    And I verify the checkout overview details: payment info "Payment Information:", sauce card "SauceCard #31337", shipping info "Shipping Information:", delivery method "Free Pony Express Delivery!", and total price "Price Total"
    And I click the finish button to complete the order
    And I click the back home button for back to homepage
    And I click on Menu icon available on the top left of the application
    And I should see a Bar containing a menus
    And I click the "Logout" menu
    Then I should be redirected to the login page with username and password fields displayed


