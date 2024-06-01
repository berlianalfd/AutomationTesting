package API.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreateUserTest {
    private Response response;
    private String appID;
    private String baseUrl = "https://dummyapi.io/data/v1";

    @Given("I have added a valid {string} in the request header")
    public void addValidAppID(String appId) {
        this.appID = appId;
        RestAssured.baseURI = baseUrl;
    }

    @When("I create a JSON script and send a POST request to endpoint {string}")
    public void SendsPostRequestToEndpoint(String endpoint) {
        String requestBody = "{\n" +
                             "  \"firstName\": \"Alina\",\n" +
                             "  \"lastName\": \"Asfika\",\n" +
                             "  \"email\": \"alfika@example.com\"\n" +
                             "}";

        response = given()
            .header("app-id", appID)
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

    @And("I see Response body contains {string}")
    public void verifyResponseBodyError(String expectedError) {
        String actualResponseBody = response.getBody().asString();
        assertTrue(actualResponseBody.contains(expectedError));
    }

    @When("I create a JSON script with the complete data as well as sending a POST request to the {string} endpoint")
    public void SendsPostRequestFullField(String endpoint) {
        String requestBody = "{\n" +
                             "  \"title\": \"mrs\",\n" +
                             "  \"firstName\": \"Zizah\",\n" +
                             "  \"lastName\": \"Natania\",\n" +
                             "  \"gender\": \"female\",\n" +
                             "  \"email\": \"zizaniap@example.com\",\n" +
                             "  \"dateOfBirth\": \"1988-05-15T00:00:00.000Z\",\n" +
                             "  \"phone\": \"081234576543\",\n" +
                             "  \"picture\": \"https://example.com/zizah.jpg\",\n" +
                             "  \"location\": {\n" +
                             "    \"street\": \"123 Main Street\",\n" +
                             "    \"city\": \"New York\",\n" +
                             "    \"state\": \"New York\",\n" +
                             "    \"country\": \"United States\",\n" +
                             "    \"timezone\": \"-8:00\"\n" +
                             "  }\n" +
                             "}";

        response = given()
                .header("app-id", appID)
                .contentType("application/json")
                .body(requestBody)
                .post(endpoint);
    }

    @Then("I see response body contains the correct user information")
    public void verifyResponseBodyFullField() {
        response.then().statusCode(200)
                .body("title", equalTo("mrs"))
                .body("firstName", equalTo("Zizah"))
                .body("lastName", equalTo("Natania"))
                .body("gender", equalTo("female"))
                .body("email", equalTo("zizaniap@example.com"))
                .body("dateOfBirth", equalTo("1988-05-15T00:00:00.000Z"))
                .body("phone", equalTo("081234576543"))
                .body("picture", equalTo("https://example.com/zizah.jpg"))
                .body("location.street", equalTo("123 Main Street"))
                .body("location.city", equalTo("New York"))
                .body("location.state", equalTo("New York"))
                .body("location.country", equalTo("United States"))
                .body("location.timezone", equalTo("-8:00"));
    }
}
