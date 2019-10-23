@Booking
Feature: Booking successfully with multiple cases

  Background:
    Given The UI of Login
    When I fill "Autotest@posbill.com" as email
    And I fill "Test12345!" as password
    And I click on Login button
    Then I see the next login screen
    And I fill "Test12345678!" as password for the next login
    And I click on Login button of the next login

  Scenario: Check with quantity in ten block. Example 2x Coca Cola
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name              |
      | ^[0-9]([a-z]{20}) |
    And I navigated to "Drinks" main group and "Soft" sub-group
    And I book articles with the following data:
      | Main Food         | Secondary Food | Price | Secondary Price | Age restriction |
      | Age Portion       | Normal         | 2,00  | 3,00            | ok              |
      | Coca cola decimal |                | 4,5   |                 |                 |
      | Pepsi Decimal     |                | 4,21  |                 |                 |
      | Coca cola decimal |                | 4,5   |                 |                 |
      | Pepsi Decimal     |                | 4,21  |                 |                 |
      | Coca cola decimal |                | 4,5   |                 |                 |
      | Pepsi Decimal     |                | 4,21  |                 |                 |
      | Pepsi Decimal     |                | 4,21  |                 |                 |
      | Coca cola decimal |                | 4,5   |                 |                 |
      | Pepsi Decimal     |                | 4,21  |                 |                 |
      | Pepsi Decimal     |                | 4,21  |                 |                 |
      | Coca cola decimal |                | 4,5   |                 |                 |
      | Pepsi Decimal     |                | 4,21  |                 |                 |
    Then The sum of added articles is equal total label

   #Test with small and large portion
  Scenario: Again with small and large
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name              |
      | ^[0-9]([a-z]{20}) |
    And I navigated to "Drinks" main group and "Soft" sub-group
    And I book articles with the following data:
      | Main Food   | Secondary Food | Price | Secondary Price | Age restriction |
      | Age Portion | Large          | 2,00  | 4,00            | ok              |
      | Age Portion | Small          | 2,00  | 2,00            |                 |
      | Age Portion | Large          | 2,00  | 4,00            |                 |
      | Age Portion | Small          | 2,00  | 2,00            |                 |
    Then The sum of added articles is equal total label

   # Test with small and large portion
  Scenario: Again with small and large and disable
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name              |
      | ^[0-9]([a-z]{20}) |
    And I navigated to "Food" main group and "Rice" sub-group
    And I book articles with the following data:
      | Main Food       | Price | Secondary Food | Secondary Price |
      | Article portion | 3,51  | Dau khuong     | 0,40            |
      | Article portion | 3,51  | Dau do         | 1,30            |
    #Disable = Name is empty
    And I book a portion is disabled
    And I click Ok button
    Then The disabled portion is not added

  Scenario: Check Cancel-Button of Age check
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name              |
      | ^[0-9]([a-z]{20}) |
    And I navigated to "Drinks" main group and "Soft" sub-group
    And I book articles with the following data:
      | Main Food   | Secondary Food | Price | Secondary Price | Age restriction |
      | Age Portion | Large          | 2,00  | 4,00            | cancel           |
    Then I see a age checking popup is appeared
    And click "CANCEL" button
    Then Item "Age Portion" is not added

  Scenario: Check Age check
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name              |
      | ^[0-9]([a-z]{20}) |
    And I navigated to "Drinks" main group and "Soft" sub-group
    And I book articles with the following data:
      | Main Food   | Secondary Food | Price | Secondary Price | Age restriction |
      | Age Portion | Large          | 2,00  | 4,00            | ok              |
    Then Item "Age Portion" is added
# Bug
  Scenario: Booking a weight and forced. When the window opened, is the value on ok set to 0€
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name              |
      | ^[0-9]([a-z]{20}) |
    And I navigated to "Drinks" main group and "Soft" sub-group
    And I click on "Weight F2 Add. Text" article with price "3,00" €
    Then A pop-up to fill weight of article appear with info "(3 € / 100gram)"
    Then price calculated as "0,00 €"

  #Bug
  Scenario: Booking a weight and forced. What happen if the field is set to 0
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name              |
      | ^[0-9]([a-z]{20}) |
    And I navigated to "Drinks" main group and "Soft" sub-group
    And I click on "Weight F2 Add. Text" article with price "3,00" €
    Then A pop-up to fill weight of article appear with info "(3 € / 100gram)"
    Then price calculated as "0,00 €"
    And I fill weight as 0
    Then "Required" error message show

  Scenario: Booking a weight and forced. What happen if the field is set to different 0
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name              |
      | ^[0-9]([a-z]{20}) |
    And I navigated to "Drinks" main group and "Soft" sub-group
    And I click on "Weight F2 Add. Text" article with price "3,00" €
    Then A pop-up to fill weight of article appear with info "(3 € / 100gram)"
    And I fill weight as "50,50"
    Then price calculated as "1,52 €"
#
  Scenario: Booking a weight and forced. Check Cancel Button
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name              |
      | ^[0-9]([a-z]{20}) |
    And I navigated to "Drinks" main group and "Soft" sub-group
    And I click on "Weight F2 Add. Text" article with price "3,00" €
    Then A pop-up to fill weight of article appear with info "(3 € / 100gram)"
    And I fill weight as "50,50"
    And I click Cancel button
    Then Item "Weight F2 Add. Text" is not added
# Bug
  Scenario: Booking a weight and forced. Check Maximum value
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name              |
      | ^[0-9]([a-z]{20}) |
    And I navigated to "Drinks" main group and "Soft" sub-group
    And I click on "Weight F2 Add. Text" article with price "3,00" €
    Then A pop-up to fill weight of article appear with info "(3 € / 100gram)"
    Then price calculated as "0,00 €"
    And I fill weight as "99999999"
    Then "Max is 99999.99." error message show
#
  Scenario: Booking a weight and forced free additional text And Check Cancel
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name              |
      | ^[0-9]([a-z]{20}) |
    And I navigated to "Drinks" main group and "Soft" sub-group
    And I click on "Weight F2 Add. Text" article with price "3,00" €
    Then A pop-up to fill weight of article appear with info "(3 € / 100gram)"
    And I fill weight as 300
    Then price calculated as "9,00 €"
    And click "9,00 €" price button
    And I choose add text article "Add. article 1"
    Then a pop-up to choose/fill additional text appear
    And select "Pretty"
    And I click Cancel button
    Then Item "Add. article 1" is not added

  Scenario: Booking a weight and forced free additional text And Check Cancel
    Given I see the operation screen
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name              |
      | ^[0-9]([a-z]{20}) |
    And I navigated to "Drinks" main group and "Soft" sub-group
    And I click on "Weight F2 Add. Text" article with price "3,00" €
    Then A pop-up to fill weight of article appear with info "(3 € / 100gram)"
    And I fill weight as 300
    Then price calculated as "9,00 €"
    And click "9,00 €" price button
    And I choose add text article "Add. article 1"
    Then a pop-up to choose/fill additional text appear
    And select "Pretty"
    Then I see "Pretty" is filled
    And I click on erase button
    Then Text "Pretty" is erased
    And select "Cold"
    Then I see "Cold" is filled
    And I click on erase button
    Then Text "Cold" is erased
    And I click Cancel button
    Then Item "Add. article 1" is not added
##
  Scenario: Booking a weight and forced free additional text And Check Erase
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name              |
      | ^[0-9]([a-z]{20}) |
    And I navigated to "Drinks" main group and "Soft" sub-group
    And I click on "Weight F2 Add. Text" article with price "3,00" €
    Then A pop-up to fill weight of article appear with info "(3 € / 100gram)"
    And I fill weight as 300
    Then price calculated as "9,00 €"
    And click "9,00 €" price button
    And I choose add text article "Add. article 1"
    Then a pop-up to choose/fill additional text appear
    And select "Pretty"
    And I click on erase button
    Then Text "Pretty" is erased
    And select "Cold"
    And I click on erase button
    Then Text "Cold" is erased

  Scenario: Booking a weight and forced free additional text And Check fill text
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name              |
      | ^[0-9]([a-z]{20}) |
    And I navigated to "Drinks" main group and "Soft" sub-group
    And I click on "Weight F2 Add. Text" article with price "3,00" €
    Then A pop-up to fill weight of article appear with info "(3 € / 100gram)"
    And I fill weight as 4000
    Then price calculated as "120,00 €"
    And click "120,00 €" price button
    And I choose add text article "Add. article 1"
    Then a pop-up to choose/fill additional text appear
    And select "Pretty"
    And click "OK" button
    Then a new selected booking appears on top booking list with name "Add. article 1" and price are same as above and additional text below as "Pretty"

  Scenario: Booking a weight and forced free additional text And Check not fill text
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name              |
      | ^[0-9]([a-z]{20}) |
    And I navigated to "Drinks" main group and "Soft" sub-group
    And I click on "Weight F2 Add. Text" article with price "3,00" €
    Then A pop-up to fill weight of article appear with info "(3 € / 100gram)"
    And I fill weight as 4000
    Then price calculated as "120,00 €"
    And click "120,00 €" price button
    And I choose add text article "Add. article 1"
    Then a pop-up to choose/fill additional text appear
    And click "OK" button
    Then a new selected booking appears on top booking list with name "Add. article 1" and price are same as above and additional text below as empty

  Scenario: Booking a 0€ and no forced additional text item and Check Cancel button
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name              |
      | ^[0-9]([a-z]{20}) |
    And I navigated to "Drinks" main group and "Soft" sub-group
    And I click on "Price  Add. Text" article with price "0,00" €
    Then a pop-up to fill price of an article
    And I fill price as "600" €
    And click "OK" button
    Then a pop-up to choose/fill additional text appear
    And select "Hot"
    And click "Cancel" button
    Then Item "Price  Add. Text" is not added
#Bug
#  Scenario: Booking a 0€ and no forced additional text item and Check maximum
#    Given I see the operation screen
#    When I create new a operation with the following data:
#      | Name              |
#      | ^[0-9]([a-z]{20}) |
#    And I navigated to "Drinks" main group and "Soft" sub-group
#    And I click on "Price  Add. Text" article with price "0,00" €
#    Then a pop-up to fill price of an article
#    And I fill price as "999999,99" €
#    Then "Max is 99999,99" error message show

#  Scenario: Booking a 0€ and no forced additional text item and Check 0
#    Given I see the operation screen
#    When I create new a operation with the following data:
#      | Name              |
#      | ^[0-9]([a-z]{20}) |
#    And I navigated to "Drinks" main group and "Soft" sub-group
#    And I click on "Price  Add. Text" article with price "0,00" €
#    Then a pop-up to fill price of an article
#    And I fill price as "0" €
#    Then "Required" error message show

  Scenario: Booking a 0€ and no forced additional text item and Check Cancel button
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name              |
      | ^[0-9]([a-z]{20}) |
    And I navigated to "Drinks" main group and "Soft" sub-group
    And I click on "Price  Add. Text" article with price "0,00" €
    Then a pop-up to fill price of an article
    And I fill price as "600" €
    And click "OK" button
    Then a pop-up to choose/fill additional text appear
    And select "Hot"
    And click "OK" button
    Then A new selected booking appears on top booking list with name "Price  Add. Text" with "600" price with only add text
    Then Only a additional text below as "Hot"


  Scenario: Booking forced additional article item with 3 items
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name              |
      | ^[0-9]([a-z]{20}) |
    And I navigated to "Drinks" main group and "Soft" sub-group
    And I book articles with the following data:
      | Main Food           | Price | Secondary Food | Secondary Price | Noted  |
      | Forced add. article | 4,00  | Add. article 1 | 1,00            | Pretty |
      |                     |       | Add. article 1 | 1,00            | Cold   |
      |                     |       | Add. article 2 | 0,50            | Empty  |
    Then "OK (3 / 2)" button enable
    And I click "OK (3 / 2)" additional article
    Then 4 items is added

  Scenario: Booking forced additional article item with cancel 12 items
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name              |
      | ^[0-9]([a-z]{20}) |
    And I navigated to "Drinks" main group and "Soft" sub-group
    And I book articles with the following data:
      | Main Food           | Price | Secondary Food | Secondary Price | Noted  |
      | Forced add. article | 4,00  | Add. article 1 | 1,00            | Pretty |
      |                     | 4,00  | Add. article 1 | 1,00            | Cold   |
      |                     | 4,00  | Add. article 2 | 0,50            | Empty  |
      |                     | 4,00  | Add. article 1 | 1,00            | Pretty |
      |                     | 4,00  | Add. article 1 | 1,00            | Cold   |
      |                     | 4,00  | Add. article 2 | 0,50            | Empty  |
      |                     | 4,00  | Add. article 1 | 1,00            | Pretty |
      |                     | 4,00  | Add. article 1 | 1,00            | Cold   |
      |                     | 4,00  | Add. article 2 | 0,50            | Empty  |
      |                     | 4,00  | Add. article 1 | 1,00            | Pretty |
      |                     | 4,00  | Add. article 1 | 1,00            | Cold   |
      |                     | 4,00  | Add. article 2 | 0,50            | Empty  |
    Then "OK (12 / 2)" button enable
    And I click cancel additional with note article
    Then I see main menu "Drinks"
    Then 0 items is added

  Scenario: Booking forced additional article item with 12 items
    Given I see the operation screen
    When I create new a operation with the following data:
      | Name              |
      | ^[0-9]([a-z]{20}) |
    And I navigated to "Drinks" main group and "Soft" sub-group
    And I book articles with the following data:
      | Main Food           | Price | Secondary Food | Secondary Price | Noted  |
      | Forced add. article | 4,00  | Add. article 1 | 1,00            | Pretty |
      |                     |       | Add. article 1 | 1,00            | Cold   |
      |                     |       | Add. article 2 | 0,50            | Empty  |
      |                     |       | Add. article 1 | 1,00            | Pretty |
      |                     |       | Add. article 1 | 1,00            | Cold   |
      |                     |       | Add. article 2 | 0,50            | Empty  |
      |                     |       | Add. article 1 | 1,00            | Pretty |
      |                     |       | Add. article 1 | 1,00            | Cold   |
      |                     |       | Add. article 2 | 0,50            | Empty  |
      |                     |       | Add. article 1 | 1,00            | Pretty |
      |                     |       | Add. article 1 | 1,00            | Cold   |
      |                     |       | Add. article 2 | 0,50            | Empty  |
    Then "OK (12 / 2)" button enable
    And I click "OK (12 / 2)" additional article
    Then I see main menu "Drinks"
    Then 13 items is added

  Scenario: Tear down booking
    Given I am in operation list screen
    When I clear all operation with start "^"
    Then I see the operation screen
