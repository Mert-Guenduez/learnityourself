#Feature: Delete user account

#  Scenario: Deletion
#    Given I am seeing the account settings
#    When I enter "****" into the password field
#    And I click on the "delete account"-button
#    Then I should see a confirmation popup

#  Scenario: Empty password field
#    Given I am seeing the account settings
#    When I click on the "delete account"-button
#    Then I should see the error message "Please enter your password."

#  Scenario: Accept Confirmation
#    Given I am seeing confirmation popup
#    When I click on the "yes"-button
#    Then I should see the login screen and a message containing "Account was deleted."

#  Scenario: Decline Confirmation
#    Given I am seeing confirmation popup
#    When I click on the "no"-button
#    Then I should see the confirmation popup closing

