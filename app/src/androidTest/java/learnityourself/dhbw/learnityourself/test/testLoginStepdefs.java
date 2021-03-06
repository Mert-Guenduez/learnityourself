package learnityourself.dhbw.learnityourself.test;

import android.app.Activity;
import android.content.Intent;
import org.junit.Rule;
import org.junit.runner.RunWith;

import androidx.test.rule.ActivityTestRule;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import learnityourself.dhbw.learnityourself.MainActivity;
import learnityourself.dhbw.learnityourself.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class testLoginStepdefs {


    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class, false, false);

    private static Activity activity;// = activityTestRule.getActivity();


    @Given("^I am seeing input fields for login$")
    public void i_am_seeing_input_fields_for_login() throws Throwable {
        activityTestRule.launchActivity(new Intent());
        activity = activityTestRule.getActivity();
        onView(withId(R.id.LoginActivity));
    }

    /*
    @Given("^I am seeing input fields for login$")
    public void iAmSeeingInputFieldsForLogin() throws Throwable {
        activityTestRule.launchActivity(new Intent());
        activity = activityTestRule.getActivity();
        onView(withId(R.id.LoginActivity));
    }
    */

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

    @When("^I click on the Login Button$")public void i_click_on_the_Login_Button() throws Throwable {
        onView(withId(R.id.login_button))
                .perform(click());
    }

    /*
    @And("^I click on the Login Button$")
    public void iClickOnTheLoginButton() throws Throwable {
        onView(withId(R.id.login_button))
                .perform(click());
    }
    */

    @Then("^I should see the Main Activity$")
    public void i_should_see_the_Main_Activity() throws Throwable {
            onView(withId(R.id.MainActivity));
    }

    /*
    @Then("^I should see the Main Activity$")
    public void iShouldSeeTheMainActivity() throws Throwable {
        onView(withId(R.id.MainActivity)).check(matches(isDisplayed()));
    }
    */

    @Then("^I should see the error message Wrong password or username$")
    public void iShouldSeeTheErrorMessageWrongPasswordOrUsername() throws Throwable {

    }

}
