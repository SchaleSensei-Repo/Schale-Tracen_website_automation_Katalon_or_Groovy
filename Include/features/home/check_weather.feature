Feature: Checking Weather Service

  Scenario: Verify weather frame updates based on location
  Given I navigate to the Schale Tracen home page
  When I select "<city>" from the weather location dropdown
  Then the weather frame should show data for "<city>"

  Examples:
    | city      |
    | Tokyo     |
    | Yokohama  |
    | Hokkaido  |