Feature: Negative API Testing with DummyAPI

  Scenario Outline: Test get user data without app-id in Headers and user ID <user_id> in the system
    Given User has opened the application in the browser
    And User has navigated to the login page
    When User selects the method "GET"
    And User sends a Request URL "/user/<user_id>" without app-id in Headers
    Then User sees "Status Response: 403 Forbidden" and "Response body: { \"error\": \"APP_ID_MISSING\" }"

    Examples:
      | user_id                         |
      | 60d0fe4f5311236168a109dd        |
      | 60d0fe4f5311236168a109KK        |
      | 60d0fe4f5311236168a109KK        |
      | 60d0fe4f5311236168a109dd        |
      | 60d0fe4f5311236168a109KK        |
      | 60d0fe4f5311236168a109dd        |
      | 1                               |
