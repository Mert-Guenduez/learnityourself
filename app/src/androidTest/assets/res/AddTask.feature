Feature: A new Task should be created and dsplayed

Scenario: Add Tasks
  Given I am seeing Tasks
  When I press on New Task
  Then I should see a new Task

