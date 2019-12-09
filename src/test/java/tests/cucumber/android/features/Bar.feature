@Bar
Feature: Bar for operation

  Background:
    Given The UI of Login
    When I fill "Autotest@posbill.com" as email
    And I fill "Test12345!" as password
    And I click on Login button
    Then I see the next login screen
    And I fill "Test12345678!" as password for the next login
    And I select "Anh" workstation
    And I click on Login button of the next login


  Scenario: Bar for multi operation
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name              |
      | ^Bar[0-9]([a-z]{6}) |
    And I navigated to "Drinks" main group and "Sub 2" sub-group
    And I book articles with the following data:
      | Main Food | Secondary Food | Price | Secondary Price | Age restriction |
      | Arc 1     |                | 1,00  |                 |                 |
      | Arc 2     |                | 1,00  |                 |                 |
      | Arc 3     |                | 1,00  |                 |                 |
    And I click on bar
    Then  I see a "Bill overview"  bar popup is appeared
    And I click "Print Invoice" button on bar popup
    Then I go to operation list screen

