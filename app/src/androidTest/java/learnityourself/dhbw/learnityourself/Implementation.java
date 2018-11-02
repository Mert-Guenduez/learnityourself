package learnityourself.dhbw.learnityourself;

public class Implementation {

    @When("^App starts$")
    public void I_input_an_email() {
    }

    @Then("^I should see Hello World$")
    public void I_should_not_see_auth_error() {
        onView(withId(R.id.error)).check(matches(not(isDisplayed())));
    }
}
