@ui
Feature: Test

  Scenario:Check Logo test wikipedia
    When Wikipedia page is opened
    Then Wikipedia logo is present

  Scenario:Check Logo test google
    When Google page is opened
    Then Google logo is present

  Scenario:Check Logo test spotify
    When Spotify page is opened
    Then Spotify logo is present