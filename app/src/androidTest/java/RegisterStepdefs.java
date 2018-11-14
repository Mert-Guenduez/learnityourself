import cucumber.api.PendingException;
import cucumber.api.java.en.Then;

class RegisterStepdefs {
    @cucumber.api.java.en.Given("^I am seeing input fields for registration$")
    public void iAmSeeingInputFieldsForRegistration() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("^I should see the error message \"([^\"]*)\" | I should see the Login screen$")
    public void iShouldSeeTheErrorMessageIShouldSeeTheLoginScreen(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I should see the error message \"([^\"]*)\"$")
    public void iShouldSeeTheErrorMessage(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}
