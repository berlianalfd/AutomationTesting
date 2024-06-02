Feature: Detail Produk Features
  As a user
  I want to view the product details page
  So that I can see detailed information about a product

  @TC0.4.1
  Scenario: Displaying the Product Detail Page
    Given I have launched the application
    And I have successfully logged in to the Swag Labs e-commerce application
    And I have navigated to the Product Detail page
    When I am on the Product Detail page which contains detailed information about a product including the product image, product name, product description, and product price
    Then the system displays the Product Detail page containing detailed information about a product including the product image, product name, product description, and product price

  @TC0.4.2
  Scenario: Adding a product to the cart by pressing the Add to cart button
    Given I have launched the application
    And I have successfully logged in to the Swag Labs e-commerce application
    And I have navigated to the Product Detail page
    When I press the "Add to cart" button
    Then the system successfully adds the product to my cart
    And the system changes the "Add to cart" button to "Remove"
    And the system notifies me about the increase in the number of items in the cart on the Cart Icon

  @TC0.4.3
  Scenario: Removing a product from the cart by pressing the Remove button
    Given I have launched the application
    And I have successfully logged in to the Swag Labs e-commerce application
    And I have navigated to the Product Detail page
    And I have added the product to the cart
    And the button is in the "Remove" state
    When I press the "Remove" button
    Then the system successfully removes the product from my cart
    And the system changes the "Remove" button to "Add to cart"
    And the system notifies me about the decrease in the number of items in the cart on the Cart Icon
