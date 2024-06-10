package reqres.api.StepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import reqres.api.Pages.ListUser;

public class ListUserSteps {
    private ListUser listUser;

    @Given("^I send a GET request to \"([^\"]*)\"$")
    public void sendGetRequest(String endpoint) {
        listUser = new ListUser();
        listUser.getUser(endpoint);
    }

    @Then("the response status should be {string}")
    public void validateResponseStatus() {
        listUser = new ListUser();
        listUser.responseStatus();
    }

    @And("the JSON response should contain {string}")
    public void theJSONResponseShouldContain() {
        listUser = new ListUser();
        listUser.containData();
    }
}

