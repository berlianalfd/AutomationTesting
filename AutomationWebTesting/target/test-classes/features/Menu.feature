Feature: Menu Feature
  As a user
  I want to be able to log in to the website and see the menu list

  Scenario: Verify Navigation Menu Options
    Given I have opened the application in the browser
    And I have been navigated to the login page
    And I successfully logged in to the Swag Labs application
    And I on the dashboard page displaying the list of catalog items
    When I click on the Menu icon located at the top left (Navigation Bar)
    Then I should see a Bar containing a list of menu options
    And the Bar should display the following menu options: All Items, About, Logout, Reset App State
