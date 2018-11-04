Feature: Manage a Missions Tasks

  Scenario: View Tasks
    Given I am in a Mission
    When I press on Tasks
    Then I should see all Mission Taks

  Scenario: Add Tasks
    Given I am seeing Tasks
    When I press on New Task
    Then I should see a new Task

  Scenario: Edit Task
    Given I am seeing Tasks
    When I press on a Task
    Then I should see the Task details
