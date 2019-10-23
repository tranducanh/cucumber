@OperationDetail
Feature: Booking successfully with items

  Background:
    Given The UI of Login
    When I fill "Autotest@posbill.com" as email
    And I fill "Test12345!" as password
    And I click on Login button
    And I fill "Test12345678!" as password for the next login
    And I click on Login button of the next login
    Then I see the operation screen


  Scenario: Booking a normal item successfully
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name              |
      | ^[0-9]([a-z]{20}) |
    And I will go to the waiter screen
    And I navigated to "Drinks" main group and "Soft" sub-group
    And I click on "Normal" article with price "1,00" €
    Then a new selected booking appears on top booking list with name "Normal" and price are same as above


  Scenario: Booking an aged check and portion item successfully
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name              |
      | ^[0-9]([a-z]{20}) |
    And I will go to the waiter screen
    And I navigated to "Drinks" main group and "Soft" sub-group
    And I click on "Age Portion" article with price "2,00" €
    Then a pop-up to choose the portion for the article appear (Small: 2€, Normal: 3€, Large: 4€)
    And I select "NORMAL" portion
    And click "OK" button
    Then a new selected booking appears on top booking list with name "Age Portion" and price are same as above

  Scenario: Booking a weight and forced free additional text item successfully
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name              |
      | ^[0-9]([a-z]{20}) |
    And I will go to the waiter screen
    And I navigated to "Drinks" main group and "Soft" sub-group
    And I click on "Weight F2 Add. Text" article with price "3,00" €
    Then A pop-up to fill weight of article appear with info "(3 € / 100gram)"
    And I fill weight as 300
    Then price calculated as "9,00 €"
    And click "9,00 €" price button
    And I choose additional article "Add. article 1"
    Then a pop-up to choose/fill additional text appear
    And select "Pretty"
    And click "OK" button
    Then a new selected booking appears on top booking list with name "Add. article 1" and price are same as above and additional text below as "Pretty"

  Scenario: Booking a 0€ and no forced additional text item successfully
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name              |
      | ^[0-9]([a-z]{20}) |
    And I will go to the waiter screen
    And I navigated to "Drinks" main group and "Soft" sub-group
    And I click on "Price  Add. Text" article with price "0,00" €
    Then a pop-up to fill price of an article
    And I fill price as "4,25" €
    And click "OK" button
    Then a pop-up to choose/fill additional text appear
    And click "OK" button
    Then a new selected booking appears on top booking list with name "Price  Add. Text" and price are same as above

  Scenario: Booking forced additional article item successfully
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name              |
      | ^[0-9]([a-z]{20}) |
    And I will go to the waiter screen
    And I navigated to "Drinks" main group and "Soft" sub-group
    And I click on "Forced add. article" article with price "4,00" €
    Then an additional article booking screen appear with "OK (0 / 2)" button disabled
    Then a new selected booking (of "Forced add. article") appears on top booking list with name and price are same as above
    Then total amount of Operation added the same amount of latest booking
    And I click on "Add. article 1" with price "1,00" €
    Then a pop-up to choose/fill additional text appear
    And select "Pretty"
    And click "OK" button
    Then additional article "Add. article 1" appear on booking list right below "Forced add.article" & Total amount/ "OK (1 / 2)" changes accordingly.
    And I click on "Add. article 2" with price "0,5" €
    Then additional article "Add. article 2" appear on booking list right below "Forced add.article" & Total amount/ "OK (2 / 2)" changes accordingly.
    Then "OK (2 / 2)" button enable
    And I click "OK (2 / 2)" additional article
    Then a new selected booking together with "Add. article 2" & "Add. article 1" additional bookings appears on top booking list with name and price are same as above
    Then total amount of Operation added the same amount of latest booking

  Scenario: Booking no-forced additional article item
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name              |
      | ^[0-9]([a-z]{20}) |
    And I will go to the waiter screen
    And I navigated to "Drinks" main group and "Soft" sub-group
    And I click on "No-Forced add. article" article with price "5,00" €
    Then "Skip (0 / 0)" button enable
    And I click "Skip" additional article
    Then I return to Operation detail without "Add. article 2" any new booking appear

  Scenario: Calculation Sum Article
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name              |
      | ^[0-9]([a-z]{20}) |
    And I will go to the waiter screen
    And I navigated to "Drinks" main group and "Soft" sub-group
    And I click on "Age Portion" article with price "2,00" €
    And click "OK" button
    Then a pop-up to choose the portion for the article appear (Small: 2€, Normal: 3€, Large: 4€)
    And I select "NORMAL" portion
    And click "OK" button
    And I click on "Normal" article with price "1,00" € with 15 times
    Then The sum of added articles is equal total label

