Feature: API method POST user data

    @TC0.0.1
    Scenario: There is no application id in the header
        When I create a JSON script and send a POST request to endpoint "/user/create"
        Then I see Response Status "403 Forbidden"
        And I see Response body contains "APP_ID_MISSING"
    
    