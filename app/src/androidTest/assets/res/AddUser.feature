Feature: Add Users to the Mission

  Scenario: Searching for Users
    Given I am seeing the Search Field for Users
    When I enter "ja" into the searchfield
    Then I am seeing all users containing "ja" in a list
