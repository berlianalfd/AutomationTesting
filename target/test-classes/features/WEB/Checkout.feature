Feature: Checkout Feature
  As a user
  I want to be able to complete the purchase process in the Swag Labs application

  @TC0.3.1
  Scenario: Pressing the Continue button on the Checkout: your Information page with all fields filled in using valid data
    Given I have opened the Swag Labs application in the browser
    And I have logged in to the Swag Labs application with username with username "standard_user" and password "secret_sauce"
    And I am on the Checkout: Your Information page displaying the First Name, Last Name, and Zip or Postal Code fields
    When I enter "Lebron" in the First Name field
    And I enter "James" in the Last Name field
    And I enter "40121" in the Zip or Postal Code field
    And I click the continue button
    Then I should be navigated to the Checkout: Overview page
    And I should see the text about Payment Information is "Payment Information:"
    And I should see the text about SauceCard is "SauceCard #31337"
    And I should see the text about Shipping Information is "Shipping Information:"
    And I should see the text about Free Pony Express Delivery is "Free Pony Express Delivery!"
    And I should see the text about Price Total is "Price Total"
    And I should see summary info

  @TC0.3.2
  Scenario: Pressing the Cancel button on the Checkout: Your Information page with all fields filled 
    Given I have opened the Swag Labs application in the browser
    And I have logged in to the Swag Labs application with username with username "standard_user" and password "secret_sauce"
    And I am on the Checkout: Your Information page displaying the First Name, Last Name, and Zip or Postal Code fields
    When I enter "Lebron" in the First Name field
    And I enter "James" in the Last Name field
    And I enter "40121" in the Zip or Postal Code field
    And I click the cancel button
    Then I should be redirected to the cart page
    And I should see the items I intend to purchase


  @TC0.3.3
  Scenario: Pressing the Cancel button on the Checkout: Your Information page with all fields missing
    Given I have opened the Swag Labs application in the browser
    And I have logged in to the Swag Labs application with username with username "standard_user" and password "secret_sauce"
    And I am on the Checkout: Your Information page displaying the First Name, Last Name, and Zip or Postal Code fields
    When I enter "" in the First Name field
    And I enter "" in the Last Name field
    And I enter "" in the Zip or Postal Code field
    And I click the cancel button
    Then I should be redirected to the cart page
    And I should see the items I intend to purchase