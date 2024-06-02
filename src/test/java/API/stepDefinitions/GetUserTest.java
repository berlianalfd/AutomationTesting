package API.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetUserTest {

    private String baseUrl = "https://dummyapi.io/data/v1/";
    private Response response;
    private String userID;
    private String appID;

    @Given("I have added user ID {string}")
    public void i_have_added_user_id(String userID) {
        this.userID = userID;
    }

    @Given("I have an application ID {string}")
    public void i_have_an_application_id(String appID) {
        this.appID = appID;
    }

    @When("I get a JSON script and send a GET request to endpoint {string}")
    public void i_get_a_json_script_and_send_a_get_request_to_endpoint(String endpoint) {
        response = RestAssured.given()
                .header("app-id", appID)
                .get(baseUrl + endpoint.replace("<userID>", userID));
    }

    @Then("I see the response status code should be {string}")
    public void i_see_the_response_status_code_should_be(String responseStatus) {
        int actualStatusCode = response.getStatusCode();
        String expectedStatusCodeString = responseStatus.split(" ")[0];
        int expectedStatusCode = Integer.parseInt(expectedStatusCodeString);
        assertEquals(expectedStatusCode, actualStatusCode);

    }

    @And("I see the response status body should contain {string} with value {string}")
    public void the_response_body_should_contain_with_value(String errorField, String expectedError) {
        String responseBody = response.getBody().asString();
        assertTrue("Response body does not contain the expected value",
                responseBody.contains("\"" + errorField + "\":\"" + expectedError + "\""));
    }
}
