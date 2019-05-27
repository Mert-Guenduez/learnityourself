package learnityourself.dhbw.learnityourself.test;
import android.app.Activity;
import android.content.Intent;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import learnityourself.dhbw.learnityourself.R;
import learnityourself.dhbw.learnityourself.ViewMissionsActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

class CreateMissionStepdefs {

    @Rule
    public ActivityTestRule<ViewMissionsActivity> activityTestRule = new ActivityTestRule<>(ViewMissionsActivity.class, false, false);

    private static Activity activity;// = activityTestRule.getActivity();


    @cucumber.api.java.en.Given("^I am seeing Missions$")
    public void iAmSeeingMissions() throws Throwable {
        activityTestRule.launchActivity(new Intent());
        activity = activityTestRule.getActivity();
        onView(withId(R.id.ViewMissionsActivity));
    }

    @When("^I press on the add symbol at the actionbar")
    public void iPressOnCreateTask() throws Throwable {
        onView(withId(R.menu.menu_add)).perform(click());
    }

    @Then("^I should see the Configuartion of a new Mission$")
    public void iShouldSeeTheConfiguartionOfANewMission() throws Throwable {
        activityTestRule.launchActivity(new Intent());
        activity = activityTestRule.getActivity();
        onView(withId(R.id.createMissionActivity));
    }

    @Given("^I am seeing a window to cofigure the new Mission$")
    public void iAmSeeingAWindowToCofigureTheNewMission() throws Throwable {
        activityTestRule.launchActivity(new Intent());
        activity = activityTestRule.getActivity();
        onView(withId(R.id.createMissionActivity));
    }

    @When("^I enter \"([^\"]*)\" into title field$")
    public void iEnterIntoTitleField(String title) throws Throwable {
        onView(withId(R.id.missionName_editText))
                .perform(typeText(title), closeSoftKeyboard());
    }

    /*
    @And("^I select \"([^\"]*)\" at datepicker$")
    public void iEnterIntoDatefield(String date) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
    */

    @And("^I click on check symbol at actionbar$")
    public void iClickOnButtonHavingText() throws Throwable {
        onView(withId(R.menu.menu_check))
                .perform(click());
    }

    @Then("^I should see a new Mission$")
    public void iShouldSeeANewMission() throws Throwable {
        activityTestRule.launchActivity(new Intent());
        activity = activityTestRule.getActivity();
        onView(withId(R.id.ViewMissionsActivity));

        //Check ob richtige mission erstellt wurde?
    }

    @When("^I click on button havong text \"([^\"]*)\"$")
    public void iClickOnButtonHavongText(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I should see a window to add Missionmembers$")
    public void iShouldSeeAWindowToAddMissionmembers() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I am seeing a window to add Missionmembers$")
    public void iAmSeeingAWindowToAddMissionmembers() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I enter \"([^\"]*)\" into search field having id \"([^\"]*)\"$")
    public void iEnterIntoSearchFieldHavingId(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Missionmember \"([^\"]*)\" appears in List$")
    public void missionmemberAppearsInList(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I am seeing a window to add Missionmembers with Missionmember in the List$")
    public void iAmSeeingAWindowToAddMissionmembersWithMissionmemberInTheList() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I click on the Missionmember \"([^\"]*)\"$")
    public void iClickOnTheMissionmember(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the Missionmember \"([^\"]*)\" is selected$")
    public void theMissionmemberIsSelected(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I am seeing a window to add Missionmembers with a selected Missionmember in the List$")
    public void iAmSeeingAWindowToAddMissionmembersWithASelectedMissionmemberInTheList() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I click on the selected Missionmember \"([^\"]*)\"$")
    public void iClickOnTheSelectedMissionmember(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the Missionmember \"([^\"]*)\" is not selected$")
    public void theMissionmemberIsNotSelected(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I am seeing a window to add Missionmembers with selcted Missionmembers in the List$")
    public void iAmSeeingAWindowToAddMissionmembersWithSelctedMissionmembersInTheList() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I click on Add Members$")
    public void iClickOnAddMembers() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I should return to the Configuration of the Mission$")
    public void iShouldReturnToTheConfigurationOfTheMission() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I am seeing a window to configure the new Mission$")
    public void iAmSeeingAWindowToConfigureTheNewMission() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I press on \"([^\"]*)\"$")
    public void iPressOn(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I am seeing a window to add Missionmembers with selected Missionmembers in the List$")
    public void iAmSeeingAWindowToAddMissionmembersWithSelectedMissionmembersInTheList() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }



}
