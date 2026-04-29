Feature: Search Functionality
  As a visitor
  I want to access the Schale Tracen website
  And search the items I want
  So that I can view the filtered content of the website

  Scenario: User successfully navigates to the home page
    Given I navigate to the Schale Tracen home page
    When I type "<term>" into the site search bar
    Then the "<category>" category should be visible
    And the "Culture & Oddities" category should be hidden
    
    Examples:
      | term    | category                      |
      | FMHY    | Tools, Indexes & Rabbitholes  |
      | maps    | Maps & Virtual Exploring      |
      | cars    | Living, Vehicles & Prices     |