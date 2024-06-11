package reqres.api.StepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import reqres.api.Pages.CreateUser;

public class CreateUserSteps {

    private CreateUser createUser;

    @Given("I send a POST request to {string} with the following data:")
    public void requestCreateUser() {
        createUser = new CreateUser();
        createUser.postUser();
    }
}
