Feature: ALl Inclusive Page for Go City

  Scenario: Verify Logo on Go City Homepage
    Given I am on Home Page
    Then Verify logo on Home Page

  Scenario: Verify Valid or Broken Links on Home Page
    Given I am on Home Page
    Then Verify Broken Links on Home Page


  Scenario: Verify day passes on Go City
    Given I am on Home Page
    When I select Pass Option
    And I select no.of passengers
    Then  Verify Same amount gets added to the cart
