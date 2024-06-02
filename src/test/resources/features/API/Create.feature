Feature: API method POST user data

    @TC0.0.1
    Scenario: There is no application id in the header
        When I create a JSON script and send a POST request to endpoint "/user/create"
        Then I see Response Status "403 Forbidden"
        And I see Response body contains "APP_ID_MISSING"

    @TC0.0.9
    Scenario: All fields are filled correctly and an email that is valid and already registered is provided
        Given I have added a valid "662df82df599010259e2e561" in the request header
        When I create a JSON script with the complete data as well as sending a POST request to the "/user/create" endpoint
        Then I see Response Status "400 Bad Request"
        And I see Response body contains "BODY_NOT_VALID"
    
    @TC0.1.0
    Scenario: Testing mandatory field checking with invalid input by leaving the title field empty
        Given I have added a valid "662df82df599010259e2e561" in the request header
        When I create a JSON script with the title field empty and send a POST request to endpoint "/user/create"
        Then I see Response Status "400 Bad Request"
        And I see Response body contains "BODY_NOT_VALID"
    
    @TC0.1.1
    Scenario: Testing mandatory checking invalid by leaving firstName field empty
        Given I have added a valid "662df82df599010259e2e561" in the request header
        When I create a JSON script with the firstName field empty and send a POST request to endpoint "/user/create"
        Then I see Response Status "400 Bad Request"
        And I see Response body contains "BODY_NOT_VALID"

    @TC0.4.0
    Scenario: Testing invalid input data by providing valid inputs, except for the location (street) field with less than 5 characters
        Given I have added a valid "662df82df599010259e2e561" in the request header
        When I create a JSON script except for the location street field with less than five characters, and send a POST request to endpoint "/user/create"
        Then I see Response Status "400 Bad Request"
        And I see Response body contains "BODY_NOT_VALID"