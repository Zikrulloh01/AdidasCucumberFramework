Feature: Adidas Order Placement Functionalities
  Agile Story: As a user, I should be able to place an order from website so that I can shop online

  @wip
  Scenario: Placing an order successfully
    Given User is on the Home Page
    When User adds an "Sony vaio i5" from "Laptops"
    And User adds an "Dell i7 8gb" from "Laptops"
    When User navigates to "Cart" page and Removes "Dell i7 8gb"
    When User clicks on placeOrder Button
    And User fills out the form and Clicks purchase button
    Then Verify expected amount equals actual amount
    And Click Ok button
