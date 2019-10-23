@LoginPostBill
Feature: User Successful Login Feature

  Scenario: Login the app successfully as a master
    Given The UI of Login
    When I fill "Autotest@posbill.com" as email
    And I fill "Test12345!" as password
    And I click on Login button
    Then I see the next login screen
    And I fill "Test12345678!" as password for the next login
    And I click on Login button of the next login
    Then I see the operation screen

  Scenario Outline: Check Wrong email-format
    Given The UI of Login
    When I fill "<WrongEmailFormat>" as email
    Then "Invalid email" error message show
    Examples:
      | WrongEmailFormat |
      | wrongusername    |

#  Scenario Outline: Check wrong Password format
#    Given The UI of Login
#    When I fill "<WrongPassFormat>" as password
#    Then "Invalid password" error message show
#    Examples:
#      | WrongPassFormat |
#      | wrongpassword   |
#      | 123abc1234      |

  Scenario Outline: Login fail - with short password
    Given The UI of Login
    When I fill "Autotest@posbill.com" as email
    When I fill "<ShortPassWord>" as password
    Then "Too Short!" error message show
    Examples:
      | ShortPassWord |
      | 123     |
      | 123456 |


  Scenario: Check what happen, if password is wrong
    Given The UI of Login
    When I fill "Autotest@posbill.com" as email
    And I fill "abc12345!" as password
    When I click on Login button
    Then "Login fehlgeschlagen Bitte überprüfen Sie Ihre Login-Daten" error message show

  Scenario: Check what happen, if username is wrong
    Given The UI of Login
    When I fill "Autotest@posbill1.com" as email
    And I fill "Test12345678!" as password
    When I click on Login button
    Then "Login fehlgeschlagen Bitte überprüfen Sie Ihre Login-Daten" error message show

  Scenario: Check what happen, when internal login is wrong
    Given The UI of Login
    When I fill "Autotest@posbill.com" as email
    And I fill "Test12345!" as password
    And I click on Login button
    Then I see the next login screen
    And I fill "1234" as password for the next login
    When I click on login
    Then "Login fehlgeschlagen Bitte überprüfen Sie Ihre Login-Daten" error message show

  Scenario: Check the function of "Remember me"
    Given The UI of Login
    When I fill "Autotest@posbill.com" as email
    And I fill "Test12345!" as password
    And I click on Login button
    Then I see the next login screen
    And I fill "Test12345678!" as password for the next login
    And I check remember me as password for the next login
    And I click on login
    Then I see the operation screen
    And Close app
    And Launch app
    #TODO Then I see the the screen remember
    Then I login form

  Scenario: Check logout function in connection to the remember me
    Given The UI of Login
    When I fill "Autotest@posbill.com" as email
    And I fill "Test12345!" as password
    And I click on Login button
    Then I see the next login screen
    And I fill "Test12345678!" as password for the next login
    And I check remember me as password for the next login
    And I click on login
    Then I see the operation screen
    And I click logout
    Then I see the next login screen
