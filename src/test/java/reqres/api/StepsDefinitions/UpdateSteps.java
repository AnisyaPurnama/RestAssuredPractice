package reqres.api.StepsDefinitions;

import io.cucumber.java.en.Given;
import reqres.api.Pages.RegisterPages;
import reqres.api.Pages.UpdatePages;

public class UpdateSteps {
    private UpdatePages updatePages;

    @Given("I send a PUT request to {string} with the following data:")
    public void iSendAPUTRequest() {
        updatePages = new UpdatePages();
        updatePages.putUpdateUser();

    }

    @Given("I send a PATCH request to {string} with the following data:")
    public void iSendAPATCHRequest() {
        updatePages = new UpdatePages();
        updatePages.patchUpdateUser();
    }
}
