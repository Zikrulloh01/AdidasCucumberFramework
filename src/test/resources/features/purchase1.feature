@parallelTest
Feature: Parallel Execution


  Background:
    Given User is on the Home Page


    @parallel
  Scenario: Verify all products exist in the products page
    Then Under "Phones" category user should be able to see following products
      | Samsung galaxy s6 |
      | Nokia lumia 1520  |
      | Nexus 6           |
      | Samsung galaxy s7 |
      | Iphone 6 32gb     |
      | Sony xperia z5    |
      | HTC One M9        |
      Then Under "Laptops" category user should be able to see following products
      | Sony vaio i5        |
      | Sony vaio i7        |
      | MacBook air         |
      | Dell i7 8gb         |
      | 2017 Dell 15.6 Inch |
      | MacBook Pro         |
    Then Under "Monitors" category user should be able to see following products
      | Apple monitor 24 |
      | ASUS Full HD     |

