@ui
Feature: Login

  Background:
    Given User is not logged in

  Scenario: Verify that all fields are displayed on login page
    When User navigates to "login" page
    Then Login page fields are displayed

  Scenario: Verify that all fields are displayed on login2 page
    When User navigates to "login" page
    Then Login page fields are displayed