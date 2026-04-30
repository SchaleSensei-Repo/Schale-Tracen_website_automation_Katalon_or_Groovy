Feature: Currency Exchange Rate API

  Scenario: Verify latest USD to IDR exchange rate
    When I request the latest USD exchange rates
    Then the response status should be 200
    And the IDR exchange rate should be a valid number
    And the IDR rate should be within a reasonable range