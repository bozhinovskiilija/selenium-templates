Feature: First Feature


  @negative
  Scenario: User try to login into the application with wrong credentials
    When User click the login button
    And Insert wrong username and password
    And Click submit button
    Then Error message should be displayed on the screen
