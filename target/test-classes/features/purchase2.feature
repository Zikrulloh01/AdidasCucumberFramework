@parallelTest
Feature: Parallel Test


  Background:
    Given User is on the Home Page

   @parallel
   Scenario: Placing an order successfully
     When User adds an "Sony vaio i5" from "Laptops"
     And User adds an "Dell i7 8gb" from "Laptops"
     When User navigates to "Cart" page and Removes "Dell i7 8gb"
     When User clicks on placeOrder Button
     And User fills out the form and Clicks purchase button
     Then Verify expected amount equals actual amount
     And Click Ok button

