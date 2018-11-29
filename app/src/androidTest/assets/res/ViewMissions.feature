Feature: View Missions of a user, Tasks of a Mission and Information of a Mission

  Scenario: View Missions
    Given I am seeing the main activity
    When I click on the missions button
    Then I see a list of all missions

  Scenario: View Tasks
    Given I am seeing a list of missions
    When I click on a mission
    Then I see a list of all tasks

  Scenario: View Information of Mission
    Given I am seeing a list of tasks
    When I click on the title of the mission at the actionbar
    Then I see the information of a mission