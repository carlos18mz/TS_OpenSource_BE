Feature: Registering with tropSmart

  Scenario: The credentials entered are valid
    Given the user is in the register window
    When you enter your credentials correctly
    Then you are registered in the application

  Scenario: The credentials entered are not valid
    Given the user is in the register window
    When you not enter your credentials correctly
    Then you are not registered in the application