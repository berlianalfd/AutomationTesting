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

public class UpdateUserTest {
    private Response response;
    private String appID;
    private String baseUrl = "https://dummyapi.io/data/v1";

    @Given("I have added the application id {string} in the request header")
    public void AddAppID(String appId) {
        this.appID = appId;
        RestAssured.baseURI = baseUrl;
    }

    @When("I create a JSON script and send a PUT request to endpoint {string}")
    public void SendPutRequestToEndpoint(String endpoint) {
        String requestBody = "{\n" +
                             "  \"firstName\": \"Berlin\",\n" +
                             "  \"lastName\": \"Syah\"\n" +
                            "}";

        response = given()
            .header("app-id", appID)
            .contentType("application/json")
            .body(requestBody)
            .put(endpoint);
    } 

    @Then("The response status code should be {string}")
    public void ResponseStatusCode(String responseStatus) {
        int actualStatusCode = response.getStatusCode();
        String expectedStatusCodeString = responseStatus.split(" ")[0];
        int expectedStatusCode = Integer.parseInt(expectedStatusCodeString);
        assertEquals(expectedStatusCode, actualStatusCode);
    }

    @And("The response body should be contains {string}")
    public void ResponseBody(String expectedError) {
        String actualResponseBody = response.getBody().asString();
        assertTrue(actualResponseBody.contains(expectedError));
    }

    @When("I create a JSON script to change all the data including the email data and send a PUT request to endpoint {string}")
    public void ChangeAllDataIncludingEmail(String endpoint) {
        String requestBody = "{\n" +
                     "  \"id\": \"60d0fe4f5311236168a109dd\",\n" +
                     "  \"title\": \"Mr\",\n" +
                     "  \"firstName\": \"Miguel\",\n" +
                     "  \"lastName\": \"Kenneth\",\n" +
                     "  \"picture\": \"https://randomuser.me/api/portraits/med/men/59.jpg\",\n" +
                     "  \"gender\": \" \",\n" +
                     "  \"email\": \"miguel.lima@example.com\",\n" +
                     "  \"dateOfBirth\": \"1979-11-05T22:21:45.623Z\",\n" +
                     "  \"phone\": \"(62) 1399-0495\",\n" +
                     "  \"location\": {\n" +
                     "    \"street\": \"9637, Rua Rio de Janeiro \",\n" +
                     "    \"city\": \"Cascavel\",\n" +
                     "    \"state\": \"AmapÃ¡\",\n" +
                     "    \"country\": \"Brazil\",\n" +
                     "    \"timezone\": \"+7:00\"\n" +
                     "  },\n" +
                     "  \"registerDate\": \"2021-06-21T21:02:10.647Z\",\n" +
                     "  \"updatedDate\": \"2021-06-21T21:02:10.647Z\"\n" +
                     "}";

        response = given()
            .header("app-id", appID)
            .contentType("application/json")
            .body(requestBody)
            .put(endpoint);
    }

    @When("I create a JSON script to change all the data without the email data and send a PUT request to endpoint {string}")
    public void ChangeAllDataWithoutEmail(String endpoint) {
        String requestBody ="{\"title\": \"mrs\"," +
                              "\"firstName\": \"yani\"," +
                              "\"lastName\": \"niniah\"," +
                              "\"gender\": \"female\"," +
                              "\"dateOfBirth\": \"1999-08-12\"," +
                              "\"phone\": \"+62826638927\"," +
                              "\"picture\": \"https://example.com/yaniiah.jpg\"," +
                              "\"location\": {" +
                                  "\"street\": \"Jl. supartman No. 123\"," +
                                  "\"city\": \"cimahi\"," +
                                  "\"state\": \"Jawa Barat\"," +
                                  "\"country\": \"Indonesia\"" +
                              "}}";
                              
        response = given()
        .header("app-id", appID)
        .contentType("application/json")
        .body(requestBody)
        .put(endpoint);

    }

    @Then("I see the response body containing the successfully updated user information")
    public void successfullyUpdatedUser_information() {
        response.then().statusCode(200)
                .body("title", equalTo("mrs"))
                .body("firstName", equalTo("yani"))
                .body("lastName", equalTo("niniah"))
                .body("gender", equalTo("female"))
                .body("email", equalTo("miguel.lima@example.com"))
                .body("dateOfBirth", equalTo("1999-08-12"))
                .body("phone", equalTo("+62826638927"))
                .body("picture", equalTo("https://example.com/yaniiah.jpg"))
                .body("location.street", equalTo("Jl. supartman No. 123"))
                .body("location.city", equalTo("cimahi"))
                .body("location.state", equalTo("Jawa Barat"))
                .body("location.country", equalTo("Indonesia"));
    }

    @When("I create a JSON script to change some the data without the email data and send a PUT request to endpoint {string}")
    public void ChangeSomeDataIncludingEmail(String endpoint) {
        String requestBody ="{\"firstName\": \"Berlin\"," +
                            "\"lastName\": \"Syah\"}";
                              
        response = given()
        .header("app-id", appID)
        .contentType("application/json")
        .body(requestBody)
        .put(endpoint);
    }

    @Then("I saw the response body containing user information mainly firstname and lastname that was successfully updated")
    public void successfullyUpdatedSomeUser_information() {
        response.then().statusCode(200)
                .body("title", equalTo("mrs"))
                .body("firstName", equalTo("Berlin"))
                .body("lastName", equalTo("Syah"))
                .body("gender", equalTo("female"))
                .body("email", equalTo("miguel.lima@example.com"))
                .body("dateOfBirth", equalTo("1999-08-12"))
                .body("phone", equalTo("+62826638927"))
                .body("picture", equalTo("https://example.com/yaniiah.jpg"))
                .body("location.street", equalTo("Jl. supartman No. 123"))
                .body("location.city", equalTo("cimahi"))
                .body("location.state", equalTo("Jawa Barat"))
                .body("location.country", equalTo("Indonesia"));
    }

   
}
