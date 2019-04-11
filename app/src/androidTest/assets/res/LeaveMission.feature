Feature: Leave Mission of a user

  Scenario: View Missions
    Given I am seeing the main activity
    When I click on the missions button
    Then I see a list of all missions
	
#  Scenario: View Mission
#    Given I am seeing a list of missions
#    When I clock on a single mission
#    Then I see a list of tasks

  Scenario: View Information of Mission
    Given I am seeing a list of tasks
    When I click on the title of the mission at the actionbar
    Then I see the information of a mission
	
#  Scenario: Leave Mission
#    Given I am seeing the information of a mission
#    When I click on the "leave mission"-button
#    And I click on the confirmation popup on "yes"
#    Then I see a list of missions without the removed mission