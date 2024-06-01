Feature: API method POST user data

    @TC0.0.1
    Scenario: There is no application id in the header
        Given I have added a valid " " in the request header
        When I create a JSON script and send a POST request to endpoint "/user/create"
        Then I see Response Status "403 Forbidden"
        And I see Response body contains "APP_ID_MISSING"
    
    @TC0.0.2
    Scenario: Fill in all fields correctly
        Given I have added a valid "662df82df599010259e2e561" in the request header
        When I create a JSON script with the complete data as well as sending a POST request to the "/user/create" endpoint
        Then I see Response Status "200 OK"
        And I see response body contains the correct user information

    @TC0.0.3
    Scenario: All fields are filled correctly and an email that is valid and already registered is provided
        Given I have added a valid "662df82df599010259e2e561" in the request header
        When I create a JSON script with the complete data as well as sending a POST request to the "/user/create" endpoint
        Then I see Response Status "400 Bad Request"
        And I see Response body contains "BODY_NOT_VALID"