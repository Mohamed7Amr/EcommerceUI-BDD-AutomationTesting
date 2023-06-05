@regression

Feature: user registers using his personal info

  Background: Common registration-flow steps
    Given user navigates to the register webpage
    When user inserts needed info
    And submit

  #Scenario1
  Scenario: user registers with valid data
  Then he receives a success message of registration


    #Scenario2
  Scenario: user tries to register with same info he used before to register
  Then he receives a message says that this user has already been registered
