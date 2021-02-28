Feature:Test Sign Up for Go City

  Scenario:Verify SignUp on Go City Homepage
    Given I am on Home Page
    When Enter <Username> as "test.user@gmail.com"
    Then Click on Submit and Sign Up
