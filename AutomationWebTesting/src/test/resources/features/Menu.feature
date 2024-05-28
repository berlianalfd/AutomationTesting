Feature: Menu Navigation Feature
  As a user
  I want to be able to navigate through the menu options in the Swag Labs application

  Scenario: Displaying Menu Options
    Given I have launched the browser
    And I have launched the Swag Labs application
    And I have successfully logged in to the E-commerce application: Swag Labs
    And I am on the dashboard page displaying a catalog of items that can be ordered by customers
    When I tap on the Menu icon available on the top left of the application
    Then I should see a Bar containing a list of menus, including All Items, About, Logout, Reset App State
