Feature: Login with tropSmart

  Scenario: The credentials entered are valid
    Given the user is in the login window
    When you enter your email and password correctly and press login
    Then you access in the application with your account

  Scenario: The credentials entered not are valid
    Given the user is in the login window
    When you not enter your email and password correctly and press login
    Then you not access in the application