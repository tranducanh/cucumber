@SearchOperation
Feature: Search Operation for items

  Background:
    Given The UI of Login
    When I fill "Autotest@posbill.com" as email
    And I fill "Test12345!" as password
    And I click on Login button
    Then I see the next login screen
    And I fill "Test12345678!" as password for the next login
    And I click on Login button of the next login

  Scenario: Search 1 operation is ok
    Given I am in operation list screen
    When I click on add operation button
    And I fill "Operation 1" for operation name
    And I click Ok button
    Then A new Operation is generated "Operation 1"
    And I go to back
    And I am in operation list screen
    And I search with keyword "Operation 1"
    Then The operation with keyword "Operation 1" is 1
    And I clear all operation with start "Operation 1"

  Scenario: Search 1 operation with special characters is ok
    Given I am in operation list screen
    When I click on add operation button
    And I fill "$%123DAt ~" for operation name
    And I click Ok button
    Then A new Operation is generated "$%123DAt ~"
    And I go to back
    And I am in operation list screen
    And I search with keyword "$%123DAt ~"
    Then The operation with keyword "$%123DAt ~" is 1
    And I clear all operation with start "$%123DAt ~"

  Scenario: Search 1 operation is ok
    Given I am in operation list screen
    When I click on add operation button
    And I fill "456#*&!123DAt ~" for operation name
    And I click Ok button
    Then A new Operation is generated "456#*&!123DAt ~"
    And I go to back
    And I am in operation list screen
    And I search with keyword "456#*&"
    Then The operation with keyword "456#*&" is 1
    And I clear all operation with start "456#*&!123DAt ~"

  Scenario: Search 5 operation is ok
    Given I am in operation list screen
    When I click on add operation button
    And I fill "Operation 1" for operation name
    And I click Ok button
    Then A new Operation is generated "Operation 1"
    And I go to back
    Then I am in operation list screen
    ############################
    And I click on add operation button
    And I fill "Operation 2" for operation name
    And I click Ok button
    Then A new Operation is generated "Operation 2"
    And I go to back
    Then I am in operation list screen
    ############################
    And I click on add operation button
    And I fill "Operation 3" for operation name
    And I click Ok button
    Then A new Operation is generated "Operation 3"
    And I go to back
    Then I am in operation list screen
    ############################
    And I click on add operation button
    And I fill "Operation 4" for operation name
    And I click Ok button
    Then A new Operation is generated "Operation 4"
    And I go to back
    Then I am in operation list screen
    ############################
    And I click on add operation button
    And I fill "Operation 5" for operation name
    And I click Ok button
    Then A new Operation is generated "Operation 5"
    And I go to back
    Then I am in operation list screen
    ############################
    And I search with keyword "Operation"
    Then The operation with keyword "Operation" is 5
    And I clear all operation with start "Operation"

