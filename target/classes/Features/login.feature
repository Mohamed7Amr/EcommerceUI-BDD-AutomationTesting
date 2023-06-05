@regression

Feature: user logs-in using username and password

  Background: Common login-flow steps
    Given user navigates to the login webpage


  #First Scenario
  Scenario:user logs-in using valid username and valid password
  When user enters "boogiemon@divalia.cf" and "123456"
  Then user is logged-in to his account


    #Second Scenario
  Scenario: user logs-in using valid username and invalid password
    When user enters "boogiemon@divalia.cf" and "654321"
    Then user is not logged-in to his account
