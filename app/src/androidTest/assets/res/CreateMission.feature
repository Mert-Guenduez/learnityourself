Feature: A new Mission should be created and displayed

Scenario: Create Mission
  Given I am seeing Missions
  When I press on the add symbol at the actionbar
  Then I should see the Configuartion of a new Mission

Scenario: Configurate a new Mission
  Given I am seeing a window to configure the new Mission
  When I enter "titleOfMission" into title field
  And I select "12.12.2018" at datepicker
  And I click on check symbol at actionbar
  Then I should see a new Mission

Scenario: Configurate a new Mission with other members
  Given I am seeing a window to configure the new Mission
  When I click on button having text "Add Missionmembers"
  Then I should see a window to add Missionmembers

Scenario: Search for Missionmembers
  Given I am seeing a window to add Missionmembers
  When I enter "nameOfMissionMember" into search field
  Then Missionmember "nameOfMissionMember" appears in List

Scenario: Select Missionmember
  Given I am seeing a window to add Missionmembers with Missionmember in the List
  When I click on the Missionmember "nameOfMissionMember"
  Then the Missionmember "nameOfMissionMember" is selected

Scenario: Disselect Missionmember
  Given I am seeing a window to add Missionmembers with a selected Missionmember in the List
  When I click on the selected Missionmember "nameOfMissionMember"
  Then the Missionmember "nameOfMissionMember" is not selected

Scenario: Add Missionmember
  Given I am seeing a window to add Missionmembers with selected Missionmembers in the List
  When I click on Add Members
  Then I should return to the Configuration of the Mission

