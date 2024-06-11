package reqres.api.StepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import reqres.api.Pages.LoginPages;
import reqres.api.Pages.RegisterPages;

public class LoginSteps {
    private LoginPages loginPages;
    private Response response;

    @Given("the user is on the login page")
    public void onTheLoginPage() {
        loginPages = new LoginPages();
        loginPages.toLoginPage();
    }

    @When("the user enters a valid username")
    public void theUserEntersAValidUsername() {
        loginPages = new LoginPages();
        loginPages.enterValidUsername();
    }

    @And("the user enters a valid password")
    public void theUserEntersAValidPassword() {
        loginPages = new LoginPages();
        loginPages.enterValidPassword();
    }

    @Then("the user should be successfully logged in")
    public void successfullyLoggedIn() {
        loginPages = new LoginPages();
        loginPages.validateLoggedIn(response);
    }

    @When("the user enters an invalid username")
    public void theUserEntersAnInvalidUsername() {
        loginPages = new LoginPages();
        loginPages.enterInvalidUsername();
    }
}
