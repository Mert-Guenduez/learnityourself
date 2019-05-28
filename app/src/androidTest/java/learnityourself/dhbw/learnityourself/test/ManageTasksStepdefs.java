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
import learnityourself.dhbw.learnityourself.ViewMissionActivity;
import learnityourself.dhbw.learnityourself.ViewMissionsActivity;
import learnityourself.dhbw.learnityourself.controller.ViewMissionController;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

class ManageTasksStepdefs {

    @Rule
    public ActivityTestRule<ViewMissionActivity> activityTestRule = new ActivityTestRule<>(ViewMissionActivity.class, false, false);

    private static Activity activity;// = activityTestRule.getActivity();

    @Given("^I am in a Mission and seeing Tasks$")
    public void iAmInAMission() throws Throwable {
        activityTestRule.launchActivity(new Intent());
        activity = activityTestRule.getActivity();
        onView(withId(R.id.ViewMissionActivity));
    }

    @Given("^I am seeing Tasks$")
    public void iAmSeeingTasks() throws Throwable {
        activityTestRule.launchActivity(new Intent());
        activity = activityTestRule.getActivity();
        onView(withId(R.id.ViewMissionActivity));
    }

    @When("^I press on New Task$")
    public void iPressOnNewTask() throws Throwable {
        onView(withId(R.menu.menu_add)).perform(click());
    }

    @Then("^I should see a new Task$")
    public void iShouldSeeANewTask() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
    @When("^I press on a Task$")
    public void iPressOnATask() throws Throwable {
        onView(withId(R.id.task_list)).perform(click());
    }

    @Then("^I should see the Task details$")
    public void iShouldSeeTheTaskDetails() throws Throwable {
        onView(withId(R.id.activity_view_task));
    }
}