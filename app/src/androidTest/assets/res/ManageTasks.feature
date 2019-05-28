Feature: Manage a Missions Tasks

  Scenario: Add Tasks
    Given I am in a Mission and seeing Tasks
    When I press on New Task
    Then I should see a new Task

  Scenario: Edit Task
    Given I am seeing Tasks
    When I press on a Task
    Then I should see the Task details
