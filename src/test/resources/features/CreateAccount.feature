Feature: Create Account Functionality


  @positive
  Scenario: User try to create account on the web site
    When User click the login button
    And Insert email address
    And Click on create an account button
    And Choose title
    And Insert first name
    And Insert last name
#    And Insert email address
    And Insert password
    And Choose "10" "10" "1991" date of birth
    And Sign up for a news paper
    And Insert company
    And Insert address
    And Insert second address
    And Insert city
    And Choose state
    And Insert zip code
    And Choose country
    And Insert additional information
    And Insert home phone
    And Insert mobile phone
    And Insert alias address
    And Click on register button
    Then Welcome message should be displayed
    And Logout from your account
