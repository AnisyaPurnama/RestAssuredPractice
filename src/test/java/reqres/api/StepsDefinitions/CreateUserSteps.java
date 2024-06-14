package reqres.api.StepsDefinitions;

import io.cucumber.java.en.Given;
import reqres.api.Requests.CreateUser;

public class CreateUserSteps {

    private CreateUser createUser;

    @Given("I send a POST request to {string} with the following data:")
    public void requestCreateUser() {
        createUser = new CreateUser();
        createUser.postUser();
    }
}
