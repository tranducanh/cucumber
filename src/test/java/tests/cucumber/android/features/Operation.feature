@Operation
Feature: User Successful Operation Feature

  Background:
    Given The UI of Login
    When I fill "Autotest@posbill.com" as email
    And I fill "Test12345!" as password
    And I click on Login button
    Then I see the next login screen
    And I fill "Test12345678!" as password for the next login
    And I click on Login button of the next login
    Then I see the operation screen

  Scenario: Generate a operation in success
    Given I am in operation list screen
    When I click on add operation button
    And I fill "Test Operation" for operation name
    And I click Ok button
    Then A new Operation is generated "Test Operation"


  Scenario: Go to waiter screen when press operation tab
    Given I am in operation list screen
    And I swipe to find tab that just added with "Test Operation" value
    Then I will go to the waiter screen

  Scenario: Check cancel button
    Given I am in operation list screen
    When I click on add operation button
    And I fill "Cancel Operation" for operation name
    And I click Cancel button
    Then I am not navigated to "Cancel Operation" Operation screen

  Scenario: Test what happen if the fields are empty
    Given I am in operation list screen
    When I click on add operation button
    And I click Ok button
    Then "Required" error message show

  Scenario: Test what happen if the fields are 30 character
    Given I am in operation list screen
    When I click on add operation button
    And I fill "30 characters 30 characters111" for operation name
    And I click Ok button
    Then I am navigated to "30 characters 30 characters111" Operation screen

  Scenario: Test what happen if the fields are 31 character
    Given I am in operation list screen
    When I click on add operation button
    And I fill "30 characters 30 characters1111" for operation name
    And I click Ok button
    Then "Too Long" error message show

  Scenario: Test what happen when the field is filled with special characters
    Given I am in operation list screen
    When I click on add operation button
    And I fill "~!1%%#^1()*@-+=}{[].><?/" for operation name
    And I click Ok button
    Then I am navigated to "~!1%%#^1()*@-+=}{[].><?/" Operation screen

  Scenario: Tear down operation
    Given I am in operation list screen
    When I clear all operation with start "A"
    And I clear all operation with start "Test Operation"
    And I clear all operation with start "~"
    And I clear all operation with start "30"
    And I clear all operation with start "header fits"
    Then I see the operation screen




