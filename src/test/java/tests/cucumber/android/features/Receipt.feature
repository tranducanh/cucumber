@Receipt
Feature: Receipt for a operation

  Background:
    Given The UI of Login
    When I fill "Autotest@posbill.com" as email
    And I fill "Test12345!" as password
    And I click on Login button
    Then I see the next login screen
    And I fill "Test12345678!" as password for the next login
    And I click on Login button of the next login

  Scenario: Receipt for a operation
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name              |
      | ^Receipt[0-9]([a-z]{5}) |
    And I navigated to "Drinks" main group and "Soft" sub-group
    And I book articles with the following data:
      | Main Food         | Secondary Food | Price | Secondary Price | Age restriction |
      | Age Portion       | Normal         | 2,00  | 3,00            | ok              |
    And I click on receipt
    Then  I see a "Receipts"  bar popup is appeared
    And I click "Receipt" button on bar popup
    Then  I see a "Bill overview"  bar popup is appeared
    And I click "Print Invoice" button on bar popup
    Then I go to operation list screen




