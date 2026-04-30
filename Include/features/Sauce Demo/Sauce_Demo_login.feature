Feature: Login to Sauce Demo

  Scenario: User successfully login to Sauce Demo
    Given I navigate to the Sauce Demo login home page
    When I input my credential
    Then I should able to login into Sauce Demo product menu