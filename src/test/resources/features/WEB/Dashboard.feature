Feature: Dashboard Feature
    As a user
    I want to see the product catalog list

    @TC0.1.2
    Scenario: Adding one product to cart when not yet adding any products
        Given I have opened the browser
        And I have opened the Swag Labs application URL
        And I have logged into the application with username with username "standard_user" and password "secret_sauce"
        And I am on the Dashboard page displaying the product catalog list
        When I click Add to cart button on the selected product in the product catalog list
        Then I received a notification about an increase in the number of items that amounted to "1" on the cart icon for the selected product added to the cart
        And the Add to cart button changes to Remove

    @TC0.1.6
    Scenario: Interacting with the dashboard by clicking on a product image
        Given I have opened the browser
        And I have opened the Swag Labs application URL
        And I have logged into the application with username with username "standard_user" and password "secret_sauce"
        And I am on the Dashboard page displaying the product catalog list
        When I click on a product image in the product catalog list
        Then I am redirected to the Product Detail page which contains more detailed information about the product including the product image, product name, product description, and product price
    
    @TC0.1.7
    Scenario: Interacting with the dashboard by clicking on a product name
        Given I have opened the browser
        And I have opened the Swag Labs application URL
        And I have logged into the application with username with username "standard_user" and password "secret_sauce"
        And I am on the Dashboard page displaying the product catalog list
        When I click on the product name in the product catalog list
        Then I am redirected to the Product Detail page which contains more detailed information about the product including the product image, product name, product description, and product price
