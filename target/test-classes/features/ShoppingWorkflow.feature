Feature: Shopping Workflow


  @Positive @SmokeTest
  Scenario: User select clothes
    When User click the dresses button
    And From the sub-menu choose summer dresses
    And Choose one of the summer dresses and click add to cart
    And Modal form for successfully added product is displayed
    Then Click continue shopping button to continue shopping
    When User click the dresses button
    And From the sub-menu choose casual dresses
    And Choose one of the casual dresses and click add to cart
    And Modal form for successfully added product is displayed
    Then Click continue shopping button to continue shopping
    And The number of product added in the cart is equal to "2"

  @Positive @SmokeTest
  Scenario: Delete product from the cart
    Given The number of product added in the cart is equal to "2"
    When I delete one product from the cart
    Then The number of product added in the cart is equal to "1"


