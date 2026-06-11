Feature: Functions of Campus Coffee
  Scenario: Compare Prices
    Given there are no registered CoffeShops
    When a CoffeShop with Name "Crazy Sheep",Location "Uni" and returnpoint true and "Cappuccino" Price 5 is added to the System
    And a CoffeShop with Name "Cafeteria",Location "Uni" and returnpoint true and "Cappuccino" Price 4 is added to the System
    And the price for "Cappuccino" gets compared for "Crazy Sheep" and "Cafeteria"
    Then the System should show "Cafeteria" as the one with cheaper coffee

    Scenario: Create CoffeeShop
      Given there are no registered CoffeShops
      When a CoffeShop with Name "CS",Location "Uni" and returnpoint true and "Cappuccino" Price 4 is added to the System
      Then the CoffeeShop with Name "CS", Location "Uni" and returnpoint true should appear
      And it should be with the only one
      #Then the System should show "Hi" as a new shop

    Scenario: Search CoffeeShop
      Given there are  registered CoffeeShops
      When Location "Uni"