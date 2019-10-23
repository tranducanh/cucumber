@Test
Feature: test for operation

  Background:
  Given The UI of Login
  When I fill "Autotest@posbill.com" as email
  And I fill "Test12345!" as password
  And I click on Login button
  Then I see the next login screen
  And I fill "Test12345678!" as password for the next login
  And I click on Login button of the next login

  Scenario: test
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name              |
      | ^[0-9]([a-z]{20}) |
    And I navigated to "Drinks" main group and "Soft" sub-group
    And I click on menu at 1 with "Operation discount (%)"
