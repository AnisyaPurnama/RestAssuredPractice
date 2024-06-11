package reqres.api.StepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.json.simple.JSONObject;
import reqres.api.Pages.ListUser;
import reqres.api.Utilities.ResponseValidator;
import reqres.api.Utilities.UserResponseData;

public class ListUserSteps {
    private ListUser listUser;
    private ResponseValidator responseValidator;
    private UserResponseData userResponseData;

    @Given("I send a GET request to {string}")
    public void sendGetRequest() {
        listUser = new ListUser();
        listUser.getUser();
    }

    @Then("the response status should be {string}")
    public void validateResponseStatus(String statusCode) {
        responseValidator = new ResponseValidator();
        responseValidator.getResponseStatus(statusCode);
    }

    @Then("the JSON response should contain {string}")
    public void theJSONResponseShouldContain(String statusCode) {
        userResponseData = new UserResponseData();
        userResponseData.containData(statusCode,null);
    }

    @Then("the JSON response should contain {jsonObject}")
    public void theJSONResponseShouldContain(JSONObject request) {
        userResponseData = new UserResponseData();
        userResponseData.containData(null,request);
    }


}

