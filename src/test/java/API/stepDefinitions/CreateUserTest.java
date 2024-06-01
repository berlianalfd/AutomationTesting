package API.stepDefinitions;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class CreateUserTest {
    private Response response;
    private String baseUrl = "https://dummyapi.io/data/v1";

    @When("I create a JSON script and send a POST request to endpoint {string}")
    public void SendsPostRequestToEndpoint(String endpoint) {
        String requestBody = "{\n" +
                                "  \"firstName\": \"Alina\",\n" +
                                "  \"lastName\": \"Asfika\",\n" +
                                "  \"email\": \"alfika@example.com\"\n" +
                             "}";

        response = given()
            .baseUri(baseUrl)
            .contentType("application/json")
            .body(requestBody)
            .post(endpoint);
    }

    @Then("I see Response Status {string}")
    public void verifyResponseStatus(String responseStatus) {
        int actualStatusCode = response.getStatusCode();
        String expectedStatusCodeString = responseStatus.split(" ")[0];
        int expectedStatusCode = Integer.parseInt(expectedStatusCodeString);
        assertEquals(expectedStatusCode, actualStatusCode);
    }

    @Then("I see Response body contains {string}")
    public void verifyResponseBodyError(String expectedError) {
        String actualResponseBody = response.getBody().asString();
        assertEquals("{\"error\":\"" + expectedError + "\"}", actualResponseBody);
    }

}
