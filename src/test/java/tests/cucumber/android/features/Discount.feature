@Discount
Feature: Set Loss for items

  Background:
    Given The UI of Login
    When I fill "Autotest@posbill.com" as email
    And I fill "Test12345!" as password
    And I click on Login button
    Then I see the next login screen
    And I fill "Test12345678!" as password for the next login
    And I click on Login button of the next login

  Scenario: Set voucher for item at index 1 and 2
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name       |
      | ^[0-9]([a-z]{20}) |
    And I navigated to "Food" main group and "Rice" sub-group
    And I book articles with the following data:
      | Main Food      | Secondary Food | Price | Secondary Price | Age restriction |
      | Discount 45,5% |                | 49    |                 |                 |
      | Discount 30%   |                | 8     |                 |                 |
      | Discount 45,5% |                | 49    |                 |                 |
      | Discount 45,5% |                | 49    |                 |                 |
    And I discount item 4 "30%"
    Then Item at index 4 is set "34,30 €" value
    And I discount item 3 "20%"
    Then Item at index 3 is set "6,40 €" value
    Then The sum of prices is "138,70"

  Scenario: Set voucher for item at index 3 and 4
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name       |
      | ^[0-9]([a-z]{20}) |
    And I navigated to "Food" main group and "Rice" sub-group
    And I book articles with the following data:
      | Main Food      | Secondary Food | Price | Secondary Price | Age restriction |
      | Discount 45,5% |                | 49    |                 |                 |
      | Discount 30%   |                | 8     |                 |                 |
      | Discount 45,5% |                | 49    |                 |                 |
      | Discount 45,5% |                | 49    |                 |                 |
    And I discount item 1 "65%"
    Then Item at index 1 is set "17,15 €" value
    And I discount item 2 "83%"
    Then Item at index 2 is set "8,33 €" value
    Then The sum of prices is "82,48"

  Scenario: Set voucher for a operation
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name          |
      | ^[0-9]([a-z]{20}) |
    And I navigated to "Food" main group and "Rice" sub-group
    And I book articles with the following data:
      | Main Food      | Secondary Food | Price | Secondary Price | Age restriction |
      | Discount 45,5% |                | 49    |                 |                 |
      | Discount 30%   |                | 8     |                 |                 |
      | Discount 45,5% |                | 49    |                 |                 |
      | Discount 45,5% |                | 49    |                 |                 |
    And I discount all "50%"
    Then The sum of prices is "77,50"


  Scenario: Set price for item at index 3 and 4
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name      |
      | ^[0-9]([a-z]{20}) |
    And I navigated to "Food" main group and "Rice" sub-group
    And I book articles with the following data:
      | Main Food      | Secondary Food | Price | Secondary Price | Age restriction |
      | Discount 45,5% |                | 49    |                 |                 |
      | Discount 30%   |                | 8     |                 |                 |
      | Discount 45,5% |                | 49    |                 |                 |
      | Discount 45,5% |                | 49    |                 |                 |
    And I set price item 1 "49,55"
    Then Item at index 1 is set "49,55 €" value
    And I set price item 2 "67,44"
    Then Item at index 2 is set "67,44 €" value
    Then The sum of prices is "173,99"
