Feature: Site API Health Check

  Scenario: Verify that the website server is responding
    When I send a GET request to the main endpoint
    Then the response status code should be 200