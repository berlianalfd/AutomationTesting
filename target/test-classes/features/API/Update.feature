Feature: API method PUT user data

@TC0.2.1
    Scenario: Not adding application Id in the header
        Given I have added the application id "" in the request header
        When I create a JSON script and send a PUT request to endpoint "/user/60d0fe4f5311236168a109dd"
        Then The response status code should be "403 Forbidden"
        And The response body should be contains "APP_ID_MISSING"

@TC0.2.2
    Scenario: Added the wrong app Id in the header
        Given I have added the application id "yw6728" in the request header
        When I create a JSON script and send a PUT request to endpoint "/user/60d0fe4f5311236168a109dd"
        Then The response status code should be "403 Forbidden"
        And The response body should be contains "APP_ID_NOT_EXIST"
      
@TC0.2.3
    Scenario: Changed all the data in the user table including the email data using the wrong app-id
        Given I have added the application id "662df824f599018ef9e2e55f" in the request header
        When I create a JSON script to change all the data including the email data and send a PUT request to endpoint "/user/60d0fe4f5311236168a109dd"
        Then The response status code should be "402 Bad Request"
        And The response body should be contains "APP_ID_NOT_EXIST"

@TC0.2.9
    Scenario: Change all data in the user table without email data with the registered app-id
        Given I have added the application id "662df824f599018ef9e2e55e" in the request header
        When I create a JSON script to change all the data without the email data and send a PUT request to endpoint "/user/60d0fe4f5311236168a109dd"
        Then The response status code should be "200 OK"
        And I see the response body containing the successfully updated user information

@TC0.2.10
    Scenario: Change some data in the user table without email data with the registered app-id
        Given I have added the application id "662df824f599018ef9e2e55e" in the request header
        When I create a JSON script to change some the data without the email data and send a PUT request to endpoint "/user/60d0fe4f5311236168a109dd"
        Then The response status code should be "200 OK"
        And I saw the response body containing user information mainly firstname and lastname that was successfully updated
