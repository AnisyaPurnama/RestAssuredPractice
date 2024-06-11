package reqres.api.StepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import reqres.api.Pages.RegisterPages;
import reqres.api.Utilities.ResponseValidator;

public class RegisterSteps {
    private Response response;

    private RegisterPages registerPages;

    @Given("the user is on the registration page")
    public void registrationPage() {
        registerPages = new RegisterPages();
        registerPages.toRegistrationPage();
    }

    @When("the user enters valid registration details")
    public void entersValidRegistrationDetails() {
        registerPages = new RegisterPages();
        registerPages.enterValidDetails();
    }

    @Then("the user should be successfully registered")
    public void successfullyRegistered() {
        registerPages = new RegisterPages();
        registerPages.validateUserRegistered(response);
    }

    @When("the user enters invalid registration details")
    public void entersInvalidRegistrationDetails() {
        registerPages = new RegisterPages();
        registerPages.enterInvalidDetails();
    }

    @Then("an error message should display")
    public void errorMessageOnDisplay() {
        ResponseValidator responseValidator = new ResponseValidator();
        responseValidator.errorMessage(response);
    }
}
