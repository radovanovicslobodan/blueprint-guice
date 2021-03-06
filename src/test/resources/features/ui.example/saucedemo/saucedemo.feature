@ui
Feature: SauceDemo Tests

  Background:
    Given I am on the SauceDemo login page

  Scenario: Login with a valid user
    Given I authenticate using valid credentials
    Then I can see the inventory page

  Scenario: Login with an invalid user
    Given I authenticate using invalid credentials
    Then I should see an error saying "Epic sadface: Username and password do not match any user in this service"

  Scenario: Logout from the home page
    Given I authenticate using valid credentials
    Then I can see the inventory page
    Given I logout from the site
    Then I am redirected to the SauceDemo login page

  Scenario: Sort products by Price (low to high)
    Given I authenticate using valid credentials
    Then I can see the inventory page
    Given I sort the products using criteria "Price (low to high)" using the sort dropdown
    Then The products are sorted by price (low to high)