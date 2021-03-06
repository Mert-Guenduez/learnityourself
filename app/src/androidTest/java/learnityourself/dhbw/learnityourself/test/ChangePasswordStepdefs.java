package learnityourself.dhbw.learnityourself.test;

import android.app.Activity;

import org.junit.Rule;

import androidx.test.rule.ActivityTestRule;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import learnityourself.dhbw.learnityourself.MainActivity;
import learnityourself.dhbw.learnityourself.R;
import learnityourself.dhbw.learnityourself.ViewMissionsActivity;
import learnityourself.dhbw.learnityourself.model.User;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

class ChangePasswordStepdefs {
    private static Activity activity;// = activityTestRule.getActivity();
    private static User user;

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class, false, false);

    @Before
    public void beforeAll() throws Exception {
        UserLogin userLogin = new UserLogin();
        user = userLogin.loginUser();
    }

    @When("^I click on edit symbol$")
    public void iClickOnEditSymbol() throws Throwable {
        onView(withId(R.menu.menu_edit)).perform(click());
    }

    @Then("^I see settings for changing the password and deleting the account$")
    public void iSeeSettingsForChangingThePasswordAndDeletingTheAccount() throws Throwable {
        onView(withId(R.id.OptionsActivity));
    }

    @Given("^I am seeing the account settings$")
    public void iAmSeeingTheAccountSettings() throws Throwable {
        onView(withId(R.id.OptionsActivity));
    }

    /*
    @When("^I enter the user's current password$")
    public void iEnterTheUserSCurrentPassword() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I enter a new password$")
    public void iEnterANewPassword() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I see a notification telling me that the password was changed$")
    public void iSeeANotificationTellingMeThatThePasswordWasChanged() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
    */
}
