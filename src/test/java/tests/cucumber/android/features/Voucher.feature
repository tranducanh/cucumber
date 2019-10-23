@Voucher
Feature: Voucher for items

  Background:
    Given The UI of Login
    When I fill "Autotest@posbill.com" as email
    And I fill "Test12345!" as password
    And I click on Login button
    Then I see the next login screen
    And I fill "Test12345678!" as password for the next login
    And I click on Login button of the next login

  Scenario: Set voucher for item at index 1
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name              |
      | ^Test[0-9]([a-z]{20}) |
    And I navigated to "Drinks" main group and "Soft" sub-group
    And I book articles with the following data:
      | Main Food         | Secondary Food | Price | Secondary Price | Age restriction |
      | Age Portion       | Normal         | 2,00  | 3,00            | ok              |
      | Age Portion       | Large         | 2,00  | 4,00            | ok              |
      | Age Portion       | Small         | 2,00  | 2,00            | ok              |
    And I click item at index 1 in ordered items
    And I click on set voucher
    Then  I see a "Vouchers"  bar popup is appeared
    And select voucher "Celerbrate 50th"
    And   I click Ok button
    Then Item at index 1 is set "0,00 €" value

  Scenario: Set vouchers for all items
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name              |
      | ^Test[0-9]([a-z]{20}) |
    And I navigated to "Drinks" main group and "Soft" sub-group
    And I book articles with the following data:
      | Main Food         | Secondary Food | Price | Secondary Price | Age restriction |
      | Age Portion       | Normal         | 2,00  | 3,00            | ok              |
      | Age Portion       | Large         | 2,00  | 4,00            | ok              |
      | Age Portion       | Small         | 2,00  | 2,00            | ok              |
    And I click item at index 1 in ordered items
    And I click on set voucher
    Then  I see a "Vouchers"  bar popup is appeared
    And select voucher "Birthday"
    And  I click Ok button
    And I click item at index 2 in ordered items
    And I click on set voucher
    Then  I see a "Vouchers"  bar popup is appeared
    And select voucher "Birthday"
    And  I click Ok button
    And I click item at index 3 in ordered items
    And I click on set voucher
    Then  I see a "Vouchers"  bar popup is appeared
    And select voucher "Birthday"
    And   I click Ok button
    Then Item at index 1 is set "0,00 €" value