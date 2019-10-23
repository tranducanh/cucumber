@ResetDeposit
Feature: Reset deposit

  Background:
    Given The UI of Login
    When I fill "Autotest@posbill.com" as email
    And I fill "Test12345!" as password
    And I click on Login button
    Then I see the next login screen
    And I fill "Test12345678!" as password for the next login
    And I click on Login button of the next login
#    And I clear all operation with start "^"

  Scenario: Reset Deposit for multi operation
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name              |
      | ^[0-9]([a-z]{20}) |
    And I navigated to "Food" main group and "Rice" sub-group
    And I book articles with the following data:
      | Main Food      | Secondary Food | Price | Secondary Price | Is Deposit |
      | Deposit main 2 | vo chai        | 5,70  | 1,00            | ok         |
      | deposit main 1 | vo chai        | 5,60  | 1,00            | ok         |
      | Deposit main 2 | vo chai        | 5,70  | 1,00            | ok         |
      | deposit main 1 | vo chai        | 5,60  | 1,00            | ok         |
      | Deposit main 2 | vo chai        | 5,70  | 1,00            | ok         |
      | deposit main 1 | vo chai        | 5,60  | 1,00            | ok         |
    And I click reset deposit
    And I choose add text article "vo chai"
    Then Item at index 1 is set "-1,00 €" value
    And I choose add text article "bao ni long"
    Then Item at index 1 is set "-0,50 €" value



