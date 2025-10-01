Feature: Shopping Cart Functionality

  Scenario: User can add a product to the cart
    Given I open the shopping cart application
    When I add the first product to the cart
    Then the cart should contain 1 item

  Scenario: User can remove product from the cart
    Given I open the shopping cart application
    And I add the first product to the cart
    When I remove the product from the cart
    Then the cart should be empty

  Scenario: User can increase product quantity in the cart
    Given I open the shopping cart application
    And I add the first product to the cart
    When I increase the quantity of the product
    Then the cart should reflect the updated quantity "2"

  Scenario: GitHub repository accessibility
    Given I open the evaluation app
    When I check the GitHub repository link
    Then the repository should be accessible and contain a README.md
