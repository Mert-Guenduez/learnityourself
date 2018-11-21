package learnityourself.dhbw.learnityourself.test;
import android.app.Activity;
import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.runner.RunWith;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import learnityourself.dhbw.learnityourself.MainActivity;
import learnityourself.dhbw.learnityourself.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class LoginStepdefs {


    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    private Activity activity = activityTestRule.getActivity();


    @Given("^I am seeing input fields for login$")
    public void iAmSeeingInputFieldsForLogin() throws Throwable {
        activityTestRule.launchActivity(new Intent());
        activity = activityTestRule.getActivity();
     onView(withId(R.id.LoginActivity));

    }

    @When("^I enter \"([^\"]*)\" into the username field$")
    public void iEnterIntoTheUsernameField(String username) throws Throwable {
        onView(withId(R.id.username_field))
                .perform(typeText(username), closeSoftKeyboard());
    }

    @And("^I enter \"([^\"]*)\" into the password field$")
    public void iEnterIntoThePasswordField(String password) throws Throwable {
        onView(withId(R.id.password_field))
                .perform(typeText(password), closeSoftKeyboard());
    }

    @And("^I click on the Login Button$")
    public void iClickOnTheLoginButton() throws Throwable {
        onView(withId(R.id.username_field))
                .perform(click());
    }

    @Then("^I should see the Main Activity$")
    public void iShouldSeeTheMainActivity() throws Throwable {
        onView(withId(R.id.MainActivity));
    }

    @Then("^I should see the error message Wrong password or username$")
    public void iShouldSeeTheErrorMessageWrongPasswordOrUsername() throws Throwable {

    }
}
