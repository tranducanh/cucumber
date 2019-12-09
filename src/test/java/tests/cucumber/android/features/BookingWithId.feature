@BookingWithId
Feature: Booking with id successfully with multiple cases

  Background:
    Given The UI of Login
    When I fill "Autotest@posbill.com" as email
    And I fill "Test12345!" as password
    And I click on Login button
    Then I see the next login screen
    And I fill "Test12345678!" as password for the next login
    And I click on Login button of the next login

  Scenario: Booking with Id
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name                   |
      | ^BookId[0-9]([a-z]{5}) |
    And I book articles with the following data:
      | Main Food Id | Main Food   | Amount | Secondary Food | Price | Secondary Price | Age restriction |
      | 2            | Age Portion | 2      | Normal         | 2,00  | 3,00            | ok              |
      | 9            | Item stock  | 2      |                | 4,00  |                 |                 |
      | 2            | Age Portion | 2      | Normal         | 2,00  | 3,00            | ok              |
      | 2            | Age Portion | 2      | Normal         | 2,00  | 3,00            | ok              |
      | 9            | Item stock  | 2      |                | 4,00  |                 |                 |
      | 2            | Age Portion | 2      | Normal         | 2,00  | 3,00            | ok              |
    Then The sum of prices is "40,00"