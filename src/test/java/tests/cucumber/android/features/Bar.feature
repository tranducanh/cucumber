@Bar
Feature: Bar for operation

  Background:
    Given The UI of Login
    When I fill "Autotest@posbill.com" as email
    And I fill "Test12345!" as password
    And I click on Login button
    Then I see the next login screen
    And I fill "Test12345678!" as password for the next login
    And I click on Login button of the next login


  Scenario: Bar for multi operation
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name              |
      | ^[0-9]([a-z]{20}) |
    And I navigated to "Drinks" main group and "Soft" sub-group
    And I book articles with the following data:
      | Main Food      | Secondary Food | Price | Secondary Price | Is Deposit |
      | Deposit main 2 | vo chai        | 5,70  | 1,00            | ok         |
      | deposit main 1 | vo chai        | 5,70  | 1,00            | ok         |

