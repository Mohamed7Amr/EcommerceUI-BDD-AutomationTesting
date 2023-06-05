@regression


Feature: Logged user could select different Categories

  #Scenario 1....
  Scenario: User can add product from Accessories to shopping-cart
    Given User logs-in to his account
    When hovers on the Accessories category
    And chooses shoes subcategory
    Then redirected to the shoes subcategory showing Shoes header
    When filters all pairs of shoes by Price from low to high
    Then all pairs of shoes will be sorted by price
    When views details of the chosen shoes product
    Then redirected to Dorian shoes details
    When selects color of the shoes product
    And chooses size of the shoes product
    And adds to cart
    Then redirected to the checkout-cart
