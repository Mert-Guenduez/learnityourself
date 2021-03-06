package learnityourself.dhbw.learnityourself.test;

import android.app.Activity;
import android.content.Intent;
import org.junit.Rule;

import androidx.test.rule.ActivityTestRule;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
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

class ViewMissionsStepdefs {
    private static User user;

    @Rule
    public ActivityTestRule<ViewMissionsActivity> activityTestRule = new ActivityTestRule<>(ViewMissionsActivity.class, false, false);

    private static Activity activity;// = activityTestRule.getActivity();

    @Before
    public void beforeAll() throws Exception {
        UserLogin userLogin = new UserLogin();
        user = userLogin.loginUser();
    }

    @cucumber.api.java.en.Given("^I am seeing the main activity$")
    public void iAmSeeingTheMainActivity() throws Throwable {
        onView(withId(R.id.MainActivity));
    }

    @When("^I click on the missions button$")
    public void iClickOnTheMissionsButton() throws Throwable {
        onView(withId(R.id.missions_button)).perform(click());
    }

    @Then("^I see a list of all missions$")
    public void iSeeAListOfAllMissions() throws Throwable {
        activityTestRule.launchActivity(new Intent());
        activity = activityTestRule.getActivity();
        onView(withId(R.id.ViewMissionsActivity));
    }

    @Given("^I am seeing a list of missions$")
    public void iAmSeeingAListOfMissions() throws Throwable {
        activityTestRule.launchActivity(new Intent());
        activity = activityTestRule.getActivity();
        onView(withId(R.id.ViewMissionsActivity));
    }

    @When("^I click on a mission$")
    public void iClickOnAMission() throws Throwable {
        onView(withId(R.id.mission_list)).perform(click());
    }

    @Then("^I see a list of all tasks$")
    public void iSeeAListOfAllTasks() throws Throwable {
        onView(withId(R.id.ViewMissionActivity));
    }

    @Given("^I am seeing a list of tasks$")
    public void iAmSeeingAListOfTasks() throws Throwable {
        onView(withId(R.id.ViewMissionActivity));
    }

    @When("^I click on the title of the mission at the actionbar$")
    public void iClickOnTheTitleOfTheMissionAtTheActionbar() throws Throwable {
        onView(withId(R.id.title)).perform(click());

    }

    @Then("^I see the information of a mission$")
    public void iSeeTheInformationOfAMission() throws Throwable {
        onView(withId(R.id.ViewMissionInformationActivity));
    }
}
