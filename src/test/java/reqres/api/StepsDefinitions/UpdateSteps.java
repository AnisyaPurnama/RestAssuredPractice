package reqres.api.StepsDefinitions;

import io.cucumber.java.en.Given;
import reqres.api.Requests.Update;

public class UpdateSteps {
    private Update update;

    @Given("I send a PUT request to {string} with the following data:")
    public void iSendAPUTRequest() {
        update = new Update();
        update.putUpdateUser();

    }

    @Given("I send a PATCH request to {string} with the following data:")
    public void iSendAPATCHRequest() {
        update = new Update();
        update.patchUpdateUser();
    }
}
