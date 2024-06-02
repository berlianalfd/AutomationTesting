Feature: API method GET user data

 @TC0.1.1
    Scenario: Not adding application id in the header and user id registered in the system 
        Given I have added user ID "<userID>"
        And I have an application ID "<app-id>"
        When I get a JSON script and send a GET request to endpoint "/user/<userID>"
        Then I see the response status code should be "403 Forbidden"
        And I see the response status body should contain "error" with value "APP_ID_MISSING"

            Examples:
        | userID                   | app-id              | 
        | 60d0fe4f5311236168a109dd |                     |

@TC0.1.2
    Scenario: Not adding application id in the header and user id is not registered in the system
        Given I have added user ID "<userID>"
        And I have an application ID "<app-id>"
        When I get a JSON script and send a GET request to endpoint "/user/<userID>"
        Then I see the response status code should be "403 Forbidden"
        And I see the response status body should contain "error" with value "APP_ID_MISSING"

            Examples:
        | userID                   | app-id              | 
        | 60d0fe4f5311236168a109KK |                     | 

@TC0.1.3
    Scenario: Added wrong application id in the header and the user id is registered in the system
        Given I have added user ID "<userID>"
        And I have an application ID "<app-id>"
        When I get a JSON script and send a GET request to endpoint "/user/<userID>"
        Then I see the response status code should be "403 Forbidden"
        And I see the response status body should contain "error" with value "APP_ID_NOT_EXIST"

            Examples:
        | userID                   | app-id                    | 
        | 60d0fe4f5311236168a109dd | 662e2bdcbb70a769232593d7  |  

@TC0.1.4
    Scenario: Added wrong application id in the header and user id is not registered in the system 
        Given I have added user ID "<userID>"
        And I have an application ID "<app-id>"
        When I get a JSON script and send a GET request to endpoint "/user/<userID>"
        Then I see the response status code should be "403 Forbidden"
        And I see the response status body should contain "error" with value "APP_ID_NOT_EXIST"

            Examples:
        | userID                   | app-id                    | 
        | 60d0fe4f5311236168a109KK | 662e2bdcbb70a769232593d7  |
@TC0.1.6
    Scenario: Added valid application id in the header and not registered user id in the system 
        Given I have added user ID "<userID>"
        And I have an application ID "<app-id>"
        When I get a JSON script and send a GET request to endpoint "/user/<userID>"
        Then I see the response status code should be "404 Not Found"
       And I see the response status body should contain "error" with value "RESOURCE_NOT_FOUND"


            Examples:
        | userID                   | app-id                    | 
        | 60d0fe4f5311236168a109KK | 662e2bdcbb70a769232593d6  |
