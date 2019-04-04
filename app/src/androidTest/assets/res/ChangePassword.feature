Feature: Change Password for user

  Scenario: View Account Settings
    Given I am seeing the main activity
    When I click on edit symbol
    Then I see settings for changing the password and deleting the account

  Scenario: Change Password
    Given I am seeing the account settings
    When I enter the user's current password
	And I enter a new password
    Then I see a notification telling me that the password was changed