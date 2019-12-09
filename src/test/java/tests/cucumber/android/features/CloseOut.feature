@CloseOut
Feature: Close out report

  Background:
    Given The UI of Login
    When I fill "Autotest@posbill.com" as email
    And I fill "Test12345!" as password
    And I click on Login button
    Then I see the next login screen
    And I fill "Test12345678!" as password for the next login
    And I select "Anh" workstation
    And I click on Login button of the next login

  Scenario: Close out a report
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name                  |
      | ^Close[0-9]([a-z]{5}) |
    Then I will go to the waiter screen
    And I navigated to "Food" main group and "Rice" sub-group
    And I book articles with the following data:
      | Main Food      | Secondary Food | Price | Secondary Price | Age restriction |
      | Discount 45,5% |                | 49    |                 |                 |
      | Discount 30%   |                | 8     |                 |                 |
      | Discount 45,5% |                | 49    |                 |                 |
      | Discount 45,5% |                | 49    |                 |                 |
    And I set the working date
    And I click on receipt
    Then  I see a "Receipts"  bar popup is appeared
    And I click "Receipt" button on bar popup
    Then  I see a "Bill overview"  bar popup is appeared
    And I click "Print Invoice" button on bar popup
    Then I go to operation list screen
    And I close out report
    Then The working date increase 1 date

  Scenario: Manual a report
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name                  |
      | ^Close[0-9]([a-z]{5}) |
    Then I will go to the waiter screen
    And I navigated to "Food" main group and "Rice" sub-group
    And I book articles with the following data:
      | Main Food      | Secondary Food | Price | Secondary Price | Age restriction |
      | Discount 45,5% |                | 49    |                 |                 |
      | Discount 30%   |                | 8     |                 |                 |
      | Discount 45,5% |                | 49    |                 |                 |
      | Discount 45,5% |                | 49    |                 |                 |
    And I set the working date
    And I click on receipt
    Then  I see a "Receipts"  bar popup is appeared
    And I click "Receipt" button on bar popup
    Then  I see a "Bill overview"  bar popup is appeared
    And I click "Print Invoice" button on bar popup
    Then I go to operation list screen
    And I choose manual report
    Then The working date increase 1 date