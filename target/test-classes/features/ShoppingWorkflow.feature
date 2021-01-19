Feature: Shopping Workflow


  @Positive @SmokeTest
  Scenario: User select clothes
    When User click the dresses button
    And From the sub-menu choose summer dresses
    And Choose one of the summer dresses and click add to cart
    And Modal form for successfully added product is displayed
    Then Click continue shopping button to continue shopping
#    And Check number of product added in the cart
    When User click the dresses button
    And From the sub-menu choose casual dresses
    And Choose one of the casual dresses and click add to cart
    And Modal form for successfully added product is displayed
    Then Click continue shopping button to continue shopping
    And Check number of product added in the cart is equal to "2"


