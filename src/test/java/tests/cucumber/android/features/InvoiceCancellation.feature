@InvoiceCancellation
Feature: Invoice Cancellation report

  Background:
    Given The UI of Login
    When I fill "Autotest@posbill.com" as email
    And I fill "Test12345!" as password
    And I click on Login button
    Then I see the next login screen
    And I fill "Test12345678!" as password for the next login
    And I select "Long" workstation
    And I click on Login button of the next login

  Scenario: Invoice cancellation
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name                    |
      | ^Invoice[0-9]([a-z]{5}) |
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
    And I select "Default" printer
    And I click "Receipt" button on bar popup
    Then  I see a "Bill overview"  bar popup is appeared
    And I click "Print Invoice" button on bar popup
    Then I go to operation list screen
    And I choose invoice cancellation
    Then  I see a "Invoice cancellation"  bar popup is appeared
    And I click the first receipt
    Then  I see a "Confirmation"  bar popup is appeared
    And   I click yes button on popup
    Then I will go to the waiter screen
    Then I see the copied operation  appeared


  Scenario: Invoice copying
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name                    |
      | ^Invoice[0-9]([a-z]{5}) |
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
    And I choose invoice copying
    Then  I see a "Invoice copy"  bar popup is appeared
    And I click the first receipt
    Then I see report appeared

  Scenario: Invoice copying 1
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name                    |
      | ^Invoice[0-9]([a-z]{5}) |
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
    And I select "Default" printer
    And I click "Receipt" button on bar popup
    Then  I see a "Bill overview"  bar popup is appeared
    And I click "Print Invoice" button on bar popup
    Then I go to operation list screen
    And I choose invoice copying
    Then  I see a "Invoice copy"  bar popup is appeared
    And I click the first receipt
    Then I see report appeared