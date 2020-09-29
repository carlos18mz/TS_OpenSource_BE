Feature: Visualize money transactions in the application

  Scenario: The user wants to see all their transactions
    Given the user is in their profile window
    When select the option “See transactions”
    Then the money transaction window will open

  Scenario: You want to see your transactions, but you have not done one.
    Given the user is in their profile window
    When you select the option See transactions but you not have done one yet
    Then the money transaction window will open with a message saying You have not made any transactions

  Scenario: Connection error when viewing transactions.
    Given the user is in their profile window
    When you select the option “see transactions” and you have lost the connection
    Then the window error while viewing transactions, loss of connection to the application.