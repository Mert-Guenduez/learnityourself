Feature: Log into app

  Scenario: Login
    Given I am seeing input fields for login
    When I enter "testuser1" into the username field
    And I enter "12345" into the password field
    And I click on the Login Button
    Then I should see the Main Activity

   #Scenario: Wrong Password
   #Given I am seeing input fields for login
   #When I enter "testuser1" into the username field
   #And I enter "13" into the password field
   #And I click on the Login Button
   #Then I should see the error message Wrong password or username
#
# Scenario: Wrong Username
#   Given I am seeing input fields for login
#   When I enter "testuser2" into the username field
#   And I enter "12345" into the password field
#   And I click on the Login Button
#   Then I should see the error message Wrong password or username
#