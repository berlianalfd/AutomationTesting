Feature: Cart Feature
    As a user
    I want to see the products that have been added to the cart
    
    @TC0.2.1
    Scenario: Verifying empty cart page
        Given I have opened the browser.
        And I have opened the Swag Labs application URL.
        And I have logged into the application with username with username "standard_user" and password "secret_sauce".
        And I am on the Dashboard page 
        When I click on the cart icon
        Then I am redirected to the cart page
        And I see the title "Your Cart"
        And I see a button to continue shopping, namely "Continue Shopping"
        And I see a button to checkout, namely "Checkout"

    @TC0.2.2
    Scenario: Verify the cart page when clicking the Continue Shopping button
        Given I have opened the browser.
        And I have opened the Swag Labs application URL.
        And I have logged into the application with username with username "standard_user" and password "secret_sauce".
        And I am on the Dashboard page 
        And I have clicked on the cart icon on the Dashboard page
        And I am on the cart page
        When I click button Continue Shopping
        Then I am redirected to the dashboard page displaying the product catalog list

    @TC0.2.3
    Scenario: Verify the cart page when clicking the Checkout button with items in the cart
        Given I have opened the browser.
        And I have opened the Swag Labs application URL.
        And I have logged into the application with username with username "standard_user" and password "secret_sauce".
        And I have added a product to the cart
        And I have clicked on the cart icon on the Dashboard page
        And I am on the cart page
        When I click the Checkout button
        Then I am redirected to the checkout page displaying the checkout information form