package reqres.api.StepsDefinitions;

import io.cucumber.java.en.Given;
import reqres.api.Requests.Delete;

public class DeleteSteps {
    private Delete delete;

    @Given("I send a DELETE request to {string}")
    public void iDelete() {
        delete = new Delete();
        delete.deleteRequest();
    }
}
