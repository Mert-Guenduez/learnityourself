package learnityourself.dhbw.learnityourself.test;

import android.app.Activity;
import android.content.Intent;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import learnityourself.dhbw.learnityourself.MainActivity;
import learnityourself.dhbw.learnityourself.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

class ViewMissionsStepdefs {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class, false, false);

    private static Activity activity;// = activityTestRule.getActivity();


    @cucumber.api.java.en.Given("^I am seeing the main activity$")
    public void iAmSeeingTheMainActivity() throws Throwable {
        activityTestRule.launchActivity(new Intent());
        activity = activityTestRule.getActivity();
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
        activityTestRule.launchActivity(new Intent());
        activity = activityTestRule.getActivity();
        onView(withId(R.id.ViewMissionActivity));
    }

    @Given("^I am seeing a list of tasks$")
    public void iAmSeeingAListOfTasks() throws Throwable {
        activityTestRule.launchActivity(new Intent());
        activity = activityTestRule.getActivity();
        onView(withId(R.id.ViewMissionActivity));
    }

    @When("^I click on the title of the mission at the actionbar$")
    public void iClickOnTheTitleOfTheMissionAtTheActionbar() throws Throwable {
        onView(withId(R.id.title)).perform(click());

    }

    @Then("^I see the information of a mission$")
    public void iSeeTheInformationOfAMission() throws Throwable {
        activityTestRule.launchActivity(new Intent());
        activity = activityTestRule.getActivity();
        onView(withId(R.id.ViewMissionInformationActivity));
    }
}
