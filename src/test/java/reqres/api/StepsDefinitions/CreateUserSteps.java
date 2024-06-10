package reqres.api.StepsDefinitions;

import io.cucumber.java.en.Given;
import reqres.api.Pages.CreateUser;
import reqres.api.Pages.ListUser;

public class CreateUserSteps {

    private CreateUser createUser;

    @Given("I send a POST request to {string} with the following data:")
    public void sendGetRequest(String arg0) {
        createUser = new CreateUser();
        createUser.postUser();
    }
}
