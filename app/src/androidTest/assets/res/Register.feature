#Feature: Register for App
#
#  Scenario: Register
#    Given I am seeing input fields for registration
#    When I enter "name" into input field having id "username_field"
#    And I enter "password1234" into input field having id "password_field"
#    And I enter "password1234" into input field having id "passwordRepeat_field"
#    And I click on button having text "Register"
#    Then I should see the error message "User already exists. Please enter another Username." | I should see the Login screen
#
#  Scenario: Empty username field
#    Given I am seeing input fields for registration
#    And I enter "password1234" into input field having id "password_field"
#    And I enter "password1234" into input field having id "passwordRepeat_field"
#    And I click on button having text "Register"
#    Then I should see the error message "Please enter valid Username."
#
#  Scenario: Empty password field
#    Given I am seeing input fields for registration
#    When I enter "name" into input field having id "username_field"
#    And I enter "password1234" into input field having id "passwordRepeat_field"
#    And I click on button having text "Register"
#    Then I should see the error message "Please repeat your Password."
#
#  Scenario: Repeated password wrong
#    Given I am seeing input fields for registration
#    When I enter "name" into input field having id "username_field"
#    And I enter "password1234" into input field having id "password_field"
#    And I enter "password1235" into input field having id "passwordRepeat_field"
#    And I click on button having text "Register"
#    Then I should see the error message "Please repeat your Password."
