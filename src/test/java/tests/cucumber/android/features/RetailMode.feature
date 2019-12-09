@RetailMode
Feature: RetailMode for operation

  Background:
    Given The UI of Login
    When I fill "Autotest@posbill.com" as email
    And I fill "Test12345!" as password
    And I click on Login button
    Then I see the next login screen
    And I fill "retailmode" as password for the next login
    And I click on Login button of the next login

  Scenario: Repeat 5 times
    Given I will go to the waiter screen
    And I navigated to "Food" main group and "Rice" sub-group
    And I book articles "Discount 45,5%" 5 times
    Then operation will increase 5 times
