Feature: Edit the MissionMembers of a Mission

  Scenario: Searching for MissionMembers
    Given I am seeing a window to edit MissionMembers
    When I enter "testuser" into the searchfield
    Then I am seeing all matching users in the userlist

  Scenario: Deleting a MissionMember
    Given I am seeing a list of users with a marked user
    When I click on the marked user
    Then The user is not marked

  Scenario: Adding a MissionMember
    Given I am seeing a list of users with a not marked user
    When I click on the not marked user
    Then The user is marked