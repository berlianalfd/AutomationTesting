Feature: Menu Navigation Feature
  As a user
  I want to be able to navigate through the menu options in the Swag Labs application

  @TC0.5.1
  Scenario: Displaying Menu Options
    Given I have launched the browser
    And I have launched the Swag Labs application
    And I have successfully logged in to the E-commerce application: Swag Labs
    And I am on the dashboard page displaying a catalog of items that can be ordered by customers
    When I tap on the Menu icon available on the top left of the application
    Then I should see a Bar containing a list of menus, including All Items, About, Logout, Reset App State

  @TC0.5.2
  Scenario: Navigating to All Items Menu
    Given I have launched the browser
    And I have launched the Swag Labs application
    And I have successfully logged in to the E-commerce application: Swag Labs
    And I am on the dashboard page displaying a catalog of items that can be ordered by customers
    When I tap on the Menu icon available on the top left of the application
    And I should see a Bar containing a list of menus
    And I tap on the "All Items" menu
    Then I should be navigated to the dashboard page displaying the product catalog

  @TC0.5.3
  Scenario: Navigating to About
    Given I have launched the browser
    And I have launched the Swag Labs application
    And I have successfully logged in to the E-commerce application: Swag Labs
    And I am on the dashboard page displaying a catalog of items that can be ordered by customers
    When I tap on the Menu icon available on the top left of the application
    And I should see a Bar containing a list of menus
    And I tap on the "About" menu
    Then I should be navigated to the page displaying information about the creators of Swag Labs

  @TC0.5.4
  Scenario: Navigating to Logout
    Given I have launched the browser
    And I have launched the Swag Labs application
    And I have successfully logged in to the E-commerce application: Swag Labs
    And I am on the dashboard page displaying a catalog of items that can be ordered by customers
    When I tap on the Menu icon available on the top left of the application
    And I should see a Bar containing a list of menus
    And I tap on the "Logout" menu
    Then I should be directed to the Login page that displays the Username and password fields as before

  @TC0.5.5
  Scenario: Navigating to Reset App State
    Given I have launched the browser
    And I have launched the Swag Labs application
    And I have successfully logged in to the E-commerce application: Swag Labs
    And I am on the dashboard page displaying a catalog of items that can be ordered by customers
    When I tap on the Menu icon available on the top left of the application
    And I should see a Bar containing a list of menus
    And I tap on the "Reset App State" menu
    Then I should be navigated to the dashboard page displaying a new catalog of items that can be ordered by customers

