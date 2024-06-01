package API.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DeleteUserTest {

    private String baseUrl = "https://dummyapi.io/data/v1/";
    private Response response;
    private String userID;
    private String appID;

    @Given("I have an user ID {string}")
    public void i_have_an_user_id(String userID) {
        this.userID = userID;
    }

    @Given("I have an app ID {string}")
    public void i_have_an_app_id(String appID) {
        this.appID = appID;
    }

    @When("I send a DELETE request to the user endpoint")
    public void i_send_a_delete_request_to_the_user_endpoint() {
        response = RestAssured.given()
                .baseUri(baseUrl)
                .header("app-id", appID)
                .delete("/user/" + userID);
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int expectedStatusCode) {
        assertEquals("Expected status code " + expectedStatusCode, expectedStatusCode, response.getStatusCode());
    }

    @Then("the response body should contain {string} with value {string}")
    public void the_response_body_should_contain_with_value(String errorField, String expectedError) {
        String responseBody = response.getBody().asString();
        assertTrue("Response body does not contain the expected value",
                responseBody.contains("\"" + errorField + "\":\"" + expectedError + "\""));
    }

}
