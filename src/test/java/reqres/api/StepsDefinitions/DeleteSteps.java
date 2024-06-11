package reqres.api.StepsDefinitions;

import io.cucumber.java.en.Given;
import reqres.api.Pages.DeletePages;
import reqres.api.Pages.ListUser;

public class DeleteSteps {
    private DeletePages deletePages;

    @Given("I send a DELETE request to {string}")
    public void iDelete() {
        deletePages = new DeletePages();
        deletePages.deleteRequest();
    }
}
