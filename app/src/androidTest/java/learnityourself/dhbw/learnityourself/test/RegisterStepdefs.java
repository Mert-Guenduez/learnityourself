package learnityourself.dhbw.learnityourself.test;
import android.app.Activity;
import android.content.Intent;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import learnityourself.dhbw.learnityourself.MainActivity;
import learnityourself.dhbw.learnityourself.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

class RegisterStepdefs {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    private Activity activity = activityTestRule.getActivity();

    @cucumber.api.java.en.Given("^I am seeing input fields for registration$")
    public void iAmSeeingInputFieldsForRegistration() throws Throwable {
        activityTestRule.launchActivity(new Intent());
        activity = activityTestRule.getActivity();
        onView(withId(R.id.RegisterActivity));
    }

    @When("^I enter \"([^\"]*)\" into the username field$")
    public void iEnterIntoTheUsernameField(String username) throws Throwable {
        onView(withId(R.id.username_field))
                .perform(typeText(username), closeSoftKeyboard());
    }

    @When("^I enter \"([^\"]*)\" into the password field$")
    public void iEnterIntoThePasswordField(String username) throws Throwable {
        onView(withId(R.id.password_field))
                .perform(typeText(username), closeSoftKeyboard());
    }

    @When("^I enter \"([^\"]*)\" into the password repeat field$")
    public void iEnterIntoThePasswordRepeatField(String username) throws Throwable {
        onView(withId(R.id.passwordRepeat_field))
                .perform(typeText(username), closeSoftKeyboard());
    }

    @And("^I click on the register button$")
    public void iClickOnTheLoginButton() throws Throwable {
        onView(withId(R.id.register_button))
                .perform(click());
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
