Feature: Negative Testing for Delete User API

  @TC0.3.1
  Scenario: Delete user without app-id in Headers
    Given I have an user ID "<userID>"
    And I have an app ID "<app-id>"
    When I send a DELETE request to the user endpoint 
    Then the response status code should be <expectedStatusCode>
    And the response body should contain "error" with value "<expectedError>"

    Examples:
      | userID                   | app-id              | expectedStatusCode | expectedError    |
      | 60d0fe4f5311236168a10a03 |                     | 403                | APP_ID_MISSING   |

  @TC0.3.2
  Scenario: Delete user with valid user ID and without app-id
    Given I have an user ID "<userID>"
    And I have an app ID "<app-id>"
    When I send a DELETE request to the user endpoint 
    Then the response status code should be <expectedStatusCode>
    And the response body should contain "error" with value "<expectedError>"

    Examples:
      | userID                   | app-id               | expectedStatusCode | expectedError    |
      | 60d0fe4f5311236168a10a03 |                      | 403                | APP_ID_MISSING   |

  @TC0.3.3
  Scenario: Delete user with valid user ID and invalid app-id
    Given I have an user ID "<userID>"
    And I have an app ID "<app-id>"
    When I send a DELETE request to the user endpoint 
    Then the response status code should be <expectedStatusCode>
    And the response body should contain "error" with value "<expectedError>"

    Examples:
      | userID                   | app-id                       |expectedStatusCode | expectedError      |
      | 60d0fe4f5311236168a10a03 | 662e2bdcbb70a769232593d7     |403                | APP_ID_NOT_EXIST   |
  
  @TC0.3.4
  Scenario: Delete user with invalid user ID and invalid app-id
    Given I have an user ID "<userID>"
    And I have an app ID "<app-id>"
    When I send a DELETE request to the user endpoint
    Then the response status code should be <expectedStatusCode>
    And the response body should contain "error" with value "<expectedError>"

    Examples:
      | userID                   | app-id                       |expectedStatusCode | expectedError      |
      | 60d0fe4f5311236168a109KK | 662e2bdcbb70a769232593d7     |403                | APP_ID_NOT_EXIST   |
  
  @TC0.3.6
  Scenario Outline: Delete user with invalid user ID and valid app-id
    Given I have an user ID "<userID>"
    And I have an app ID "<app-id>"
    When I send a DELETE request to the user endpoint 
    Then the response status code should be <expectedStatusCode>
    And the response body should contain "error" with value "<expectedError>"

    Examples:
      | userID                   | app-id                       |expectedStatusCode | expectedError      |
      | 60d0fe4f5311236168a109KK | 662e2bdcbb70a769232593d6     |404                | RESOURCE_NOT_FOUND   |
