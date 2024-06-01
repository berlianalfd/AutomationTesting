Feature: Logout Feature
  As a user
  I want to be able to log out of the website

  @TC0.7.1
  Scenario: Successful logout
    Given I have opened the web application in the browser
    And I successfully login to the E-commerce application: Swag Labs
    And I am on the dashboard page that displays a list of catalogue items that can be ordered by customers
    When I click the Menu navigation bar
    And I click the Logout menu 
    Then I should be directed to the Login page that displays the Username and password fields