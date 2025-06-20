package reqres.api.StepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import reqres.api.Requests.Register;
import reqres.api.Utilities.ResponseValidator;

public class RegisterSteps {
    private Response response;

    private Register register;

    @Given("the user is on the registration page")
    public void registrationPage() {
        register = new Register();
        register.toRegistrationPage();
    }

    @When("the user enters valid registration details")
    public void entersValidRegistrationDetails() {
        register = new Register();
        register.enterValidDetails();
    }

    @Then("the user should be successfully registered")
    public void successfullyRegistered() {
        register = new Register();
        register.validateUserRegistered(response);
    }

    @When("the user enters invalid registration details")
    public void entersInvalidRegistrationDetails() {
        register = new Register();
        register.enterInvalidDetails();
    }

    @Then("an error message should display")
    public void errorMessageOnDisplay() {
        ResponseValidator responseValidator = new ResponseValidator();
        responseValidator.errorMessage(response);
    }
}
