#Feature: Register for App
#
#  Scenario: Register
#    Given I am seeing input fields for registration
#    When I enter "name" into the username field
#    And I enter "password1234" into the password field
#    And I enter "password1234" into the password repeat field
#    And I click on button having text "Register"
#    Then I should see the error message "User already exists. Please enter another Username." | I should see the Login screen
#
#  Scenario: Empty username field
#    Given I am seeing input fields for registration
#    When I enter "password1234" into the password field
#    And I enter "password1234" into the password repeat field
#    And I click on the register button
#    Then I should see the error message "Please enter valid Username."
#
#  Scenario: Empty password field
#    Given I am seeing input fields for registration
#    When I enter "name" into the username field
#    And I enter "password1234" into the password repeat field
#    And I click on the register button
#    Then I should see the error message "Please repeat your Password."

#  Scenario: Empty password repeat field
#    Given I am seeing input fields for registration
#    When I enter "name" into the username field
#    And I enter "password1234" into the password field
#    And I click on the register button
#    Then I should see the error message "Please repeat your Password."

#  Scenario: Empty fields
#    Given I am seeing input fields for registration
#    When I click on the register button
#    Then I should see the error message "Please enter valid Username." and "Please repeat your password."
#
#  Scenario: Repeated password wrong
#    Given I am seeing input fields for registration
#    When I enter "name" into the username field
#    And I enter "password1234" into the password field
#    And I enter "password1235" into the password repeat field
#    And I click on the register button
#    Then I should see the error message "Please repeat your Password."

