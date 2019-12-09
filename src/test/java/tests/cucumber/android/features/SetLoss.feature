@SetLoss
Feature: Set Loss for items

  Background:
    Given The UI of Login
    When I fill "Autotest@posbill.com" as email
    And I fill "Test12345!" as password
    And I click on Login button
    Then I see the next login screen
    And I fill "Test12345678!" as password for the next login
    And I click on Login button of the next login

  Scenario: Set loss for item at index 1
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name              |
      | ^setloss[0-9]([a-z]{5}) |
    And I navigated to "Drinks" main group and "Soft" sub-group
    And I book articles with the following data:
      | Main Food         | Secondary Food | Price | Secondary Price | Age restriction |
      | Age Portion       | Normal         | 2,00  | 3,00            | ok              |
    And I click item at index 1 in ordered items
    And I click on set loss
#    Then  I see a "Confirmation"  bar popup is appeared
    And   I click yes button on popup
    Then Item at index 1 is set "0,00 €" value

  Scenario: set loss for last item
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name              |
      | ^setloss[0-9]([a-z]{5}) |
    And I navigated to "Drinks" main group and "Soft" sub-group
    And I book articles with the following data:
      | Main Food           | Price | Secondary Food | Secondary Price | Noted  |
      | Forced add. article | 4,00  | Add. article 1 | 1,00            | Pretty |
      |                     |       | Add. article 1 | 1,00            | Cold   |
      |                     |       | Add. article 2 | 0,50            | Empty  |
    Then "OK (3 / 2)" button enable
    And I click "OK (3 / 2)" additional article
    Then I will go to the waiter screen
    And I click item at index 4 in ordered items
    And I click on set loss
#    Then  I see a "Confirmation"  bar popup is appeared
    And I click yes button on popup
    Then Item at index 4 is set "0,00 €" value





