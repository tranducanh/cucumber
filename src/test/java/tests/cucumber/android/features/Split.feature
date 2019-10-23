@Split
Feature: split a booking successfully

  Background:
    Given The UI of Login
    When I fill "Autotest@posbill.com" as email
    And I fill "Test12345!" as password
    And I click on Login button
    Then I see the next login screen
    And I fill "Test12345678!" as password for the next login
    And I click on Login button of the next login

  Scenario: 20 items arcs and check number of items split ok
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name               |
      | ^^[0-9]([a-z]{20}) |
    And I navigated to "Drinks" main group and "Sub 2" sub-group
    And I book articles with the following data:
      | Main Food | Secondary Food | Price | Secondary Price | Age restriction |
      | Arc 1     |                | 1,00  |                 |                 |
      | Arc 2     |                | 1,00  |                 |                 |
      | Arc 3     |                | 1,00  |                 |                 |
      | Arc 4     |                | 1,00  |                 |                 |
      | Arc 10    |                | 1,00  |                 |                 |
      | Arc 11     |                | 1,00  |                 |                 |
      | Arc 12     |                | 1,00  |                 |                 |
      | Arc 13    |                | 1,00  |                 |                 |
    And I click on splitting
    Then I see a split board
    And I choose "Arc 1" in main board
    Then  I see that split board contains 1 items
    And I choose "Arc 10" in main board
    Then  I see that split board contains 2 items
    And I choose "Arc 3" in main board
    Then  I see that split board contains 3 items

  Scenario: 20 items arcs and total of splitting is ok
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name              |
      | ^[0-9]([a-z]{5}) |
    And I navigated to "Drinks" main group and "Sub 2" sub-group
    And I book articles with the following data:
      | Main Food | Secondary Food | Price | Secondary Price | Age restriction |
      | Arc 1     |                | 1,00  |                 |                 |
      | Arc 2     |                | 1,00  |                 |                 |
      | Arc 3     |                | 1,00  |                 |                 |
    And I click on splitting
    Then I see a split board
    And I choose "Arc 2" in main board
    Then  I see that split board contains 1 items
    And I choose "Arc 3" in main board
    Then  I see that split board contains 2 items
    Then The balance on main board will be "1,00"
    Then The balance on split board will be "2,00"
