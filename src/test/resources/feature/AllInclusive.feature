Feature:ALl Inclusive Page for Go City

 Scenario :Verify day passes on Go City
   Given I am on Home Page
   When  I select Pass Option
   And   I select no.of passengers
   And   Then I checkout
   Then  Verify Same amount gets added to the cart
