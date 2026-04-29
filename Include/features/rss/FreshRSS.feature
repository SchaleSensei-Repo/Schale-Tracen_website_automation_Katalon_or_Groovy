Feature: FreshRSS Authentication

  Scenario: User successfully logs in and out of FreshRSS
    Given I navigate to the Schale Tracen home page
    When I click the "News" navigation link
    Then I should be redirected to the FreshRSS landing page
    And I log in with my dummy credentials
    Then I should see that I am successfully logged in
    When I log out of FreshRSS
    Then I should see the login screen again